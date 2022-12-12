import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener {
boolean upPressed, downPressed, rightPressed, leftPressed;
char up, down, left, right;
public KeyControl(char up, char down, char left, char right){
    this.up = up;
    this.down = down;
    this.left = left;
    this.right = right;
}

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    int keyTyped = e.getKeyCode();

     if(keyTyped == up){
         upPressed = true;
     }
        if(keyTyped==down){
            downPressed = true;
        }

        if(keyTyped==left){
            leftPressed = true;
        }

        if(keyTyped==right){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyTyped = e.getKeyCode();
        if(keyTyped==up){
            upPressed = false;
        }
        if(keyTyped==down){
            downPressed = false;
        }

        if(keyTyped==left){
            leftPressed = false;
        }

        if(keyTyped==right){
            rightPressed = false;
        }

    }
}
