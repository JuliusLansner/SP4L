import javax.swing.*;
import java.awt.*;

public class ScreenDisplay extends JPanel implements Runnable {
    JFrame screen;

    private JPanel display(){
        this.setPreferredSize(new Dimension(500,800));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
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
        Thread gameThread = new Thread();
        gameThread.run();
    }

    @Override
    public void run() {
        repaint();
    }

    public void paint(Graphics g){
        this.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(100,100,20,20);
    }
}
