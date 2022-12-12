import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class FireBall implements Abilities {


public final int speed = 4;



    public void draw(Graphics g,int x, int y){
        BufferedImage[] pics = new BufferedImage[3];
        Random rn = new Random();

        try {

            pics[0] = ImageIO.read(getClass().getResourceAsStream("/res/Fireball1.gif"));
            pics[1] = ImageIO.read(getClass().getResourceAsStream("/res/Fireball2.gif"));
            pics[2] = ImageIO.read(getClass().getResourceAsStream("/res/Fireball3.gif"));
            for (int i = 0; i <4 ; i++) {
                g.drawImage(pics[rn.nextInt(3)],x,y,100,100,null);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
