import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;

public class ScreenDisplay extends JPanel implements Runnable {
    JFrame screen = new JFrame();
    FireBall fireball = new FireBall();
    CollisionChecker collisionCheck = new CollisionChecker();
    Thread gameThread;
    KeyControl keys = new KeyControl('W','S','A','D');
    KeyControl keys2 = new KeyControl('I','K','J','L');
    KeyControlAbilities player1AB = new KeyControlAbilities('E');
    KeyControlAbilities player2AB = new KeyControlAbilities('U');
    Player player1 = new Player(keys,player1AB);
    Player2 player2 = new Player2(keys2,player2AB);
    Sound sound = new Sound();


    JFrame sd1 = new JFrame();


    MapMaker map = new MapMaker();
    HealthBar health = new HealthBar();

    public int tileSize = 48;
    int screenCol = 20;
    int screenRow = 16;
    int screenWidth = tileSize * screenCol;
    int screenHeight = tileSize * screenRow;
    int fps = 60;



    private JPanel display(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keys);

        this.addKeyListener(keys2);

        this.addKeyListener(player1AB);
        this.addKeyListener(player2AB);

        this.setFocusable(true);//sets it to be focused on key input
        return this;
    }

    public void screen(){
        screen.add(display());
        screen.setVisible(true);
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//closes the program when the window is closed
        screen.pack();// Does so the screen size adjust to the JPanels size
        playMusic(0);


    }

    public void runGameThread(){//Starts the thread which makes the run method start.
        gameThread = new Thread(this);
        gameThread.run();
    }

    @Override
    public void run() {
        long drawInterval = 1000000000/fps;// 1 second split in 60
        long totalTimePlusInterval = System.nanoTime() + drawInterval;
        while(gameThread!=null){ //Gameloop that runs this until thread stops
            updatePosition();
            repaint();//Runs paint method
            long remainingTimeInMili = (totalTimePlusInterval-System.nanoTime())/1000000;
            if(remainingTimeInMili<0){
                remainingTimeInMili=0;
            }

            try {
                Thread.sleep(remainingTimeInMili);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalTimePlusInterval+=drawInterval;
        }
    }

    public void playMusic(int i){
        sound.setMusicFile(i);
        sound.playMusic();
        sound.loopMusic();
    }

    public void playSEMusic(int i){
        sound.setMusicFile(i);
        sound.playMusic();
    }
    public void stopSEMusic(){
        sound.stopMusic();
    }




    public void updatePosition(){
player1.update();
player2.update();

    }

    public void paint(Graphics g){
        this.paintComponent(g);

        try {
            map.drawMap(g);
            updatePosition();
            player1.draw(g);
            player2.drawRed(g);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        g.dispose();

    }

    void play(){
        StartGame start = new StartGame();
        screen();
        runGameThread();

    }
}
