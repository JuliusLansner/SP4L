import java.awt.*;

public class HealthBar {




    public void drawHealth(Graphics g,int x,int y,int health){
        g.setColor(Color.black);
        g.drawRect(x,y,40,10);
        g.setColor(Color.red);
       g.fillRect(x,y,health,10);
    }
}
