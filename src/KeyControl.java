import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener {
boolean upPressed, downPressed, rightPressed, leftPressed;


    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    int keyTyped = e.getKeyCode();

     if(keyTyped==KeyEvent.VK_W){
         upPressed = true;
     }
        if(keyTyped==KeyEvent.VK_S){
            downPressed = true;
        }

        if(keyTyped==KeyEvent.VK_A){
            leftPressed = true;
        }

        if(keyTyped==KeyEvent.VK_D){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyTyped = e.getKeyCode();
        if(keyTyped==KeyEvent.VK_W){
            upPressed = false;
        }
        if(keyTyped==KeyEvent.VK_S){
            downPressed = false;
        }

        if(keyTyped==KeyEvent.VK_A){
            leftPressed = false;
        }

        if(keyTyped==KeyEvent.VK_D){
            rightPressed = false;
        }

    }
}
