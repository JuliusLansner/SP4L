import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;

public class ScreenDisplay extends JPanel implements Runnable {
    JFrame screen;
    FireBall fireball = new FireBall();
    CollisionChecker collisionCheck = new CollisionChecker();
    Thread gameThread;
    KeyControl keys = new KeyControl('W','S','A','D');
    KeyControl keys2 = new KeyControl('I','K','J','L');
    KeyControlAbilities player1AB = new KeyControlAbilities('E');
    KeyControlAbilities player2AB = new KeyControlAbilities('U');
    Player player1 = new Player(keys,player1AB);
    Player2 player2 = new Player2(keys2,player2AB);



    MapMaker map = new MapMaker();
    HealthBar health = new HealthBar();

    public int tileSize = 48;
    int screenCol = 20;
    int screenRow = 16;
    int screenWidth = tileSize * screenCol;
    int screenHeight = tileSize * screenRow;
    int fps = 80;



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
        screen = new JFrame();
        screen.add(display());
        screen.setVisible(true);
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//closes the program when the window is closed
        screen.pack();// Does so the screen size adjust to the JPanels size


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

    public void collisionAttacksPlayer1(){
        if(player1.keyQ.abilityPressed) {
            if (collisionCheck.collisionCheck(player1.ability1x + player1.x, player1.ability1y + player1.y, 35, 20, player2.x, player2.y, 48, 48) == true) {
                player2.health -= 1;
            }
        }
    }

    public void collisionAttacksPlayer2(){
        if(player2.keyO.abilityPressed) {
            if (collisionCheck.collisionCheck(player2.ability1x + player2.x, player2.ability1y + player2.y, 35, 20, player1.x, player1.y, 48, 48) == true) {
                player1.health -= 1;
            }
        }
    }

    public void updatePosition(){
        collisionAttacksPlayer1();
        collisionAttacksPlayer2();
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

}
