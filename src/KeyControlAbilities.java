import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControlAbilities implements KeyListener {

    public boolean qPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        //Not used. Needed for "KeyListener"
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyTouched = e.getKeyCode();
        if (keyTouched == KeyEvent.VK_Q){
            qPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyTouched = e.getKeyCode();
        if(keyTouched == KeyEvent.VK_Q){
           qPressed = false;
    }
}
}
