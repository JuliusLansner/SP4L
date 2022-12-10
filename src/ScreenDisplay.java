import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class ScreenDisplay extends JPanel implements Runnable {
    JFrame screen;
    Thread gameThread;
    KeyControl keys = new KeyControl();
     int rectPositionx = 100;
     int rectPositiony = 100;

     int fps = 60;

    private JPanel display(){
        this.setPreferredSize(new Dimension(500,800));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keys);
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
        long systemTime = System.nanoTime();
        long drawInterval = 1000000000/fps; // 1 second split in 60
        long totalTimePlusInterval = System.nanoTime() + drawInterval;
        long remainingTime = totalTimePlusInterval - System.nanoTime();// the time thread should sleep after functions have run.

        long remainingTimeinMili = remainingTime/1000000; //Changed to mili to put into sleep function.

        while(gameThread!=null){ //Gameloop that runs this until thread stops
            updatePosition();
            repaint();//Runs paint method
            try {
                Thread.sleep(remainingTimeinMili);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            updatePosition();
        }
    }

    public void updatePosition(){

        if(keys.upPressed==true){
            rectPositiony-=4;
        }

        if(keys.downPressed==true){
            rectPositiony+=4;
        }
        if(keys.rightPressed==true){
            rectPositionx+=4;
        }
        if(keys.leftPressed==true){
            rectPositionx-=4;
        }
    }
    public void paint(Graphics g){
        this.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(rectPositionx,rectPositiony,20,20);//Eksempel på tegning.
        g.dispose();
    }
}
