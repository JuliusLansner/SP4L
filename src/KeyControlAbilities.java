import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControlAbilities implements KeyListener {
char abilityKey;
    public KeyControlAbilities(char abilityKey){
        this.abilityKey = abilityKey;

    }
    public boolean qPressed,abilityPressed;


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

        if(keyTouched == abilityKey){
            abilityPressed = true;
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
