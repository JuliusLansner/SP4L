import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class FireBall implements Abilities {

    private String direction = "";
    private int xPos = 0;
    private int yPos = 0;


    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void draw(Graphics g){

        update();

        BufferedImage[] pics = new BufferedImage[3];
        Random rn = new Random();

        try {

            pics[0] = ImageIO.read(getClass().getResourceAsStream("/res/Fireball1.gif"));
            pics[1] = ImageIO.read(getClass().getResourceAsStream("/res/Fireball2.gif"));
            pics[2] = ImageIO.read(getClass().getResourceAsStream("/res/Fireball3.gif"));

                g.drawImage(pics[rn.nextInt(3)],this.xPos,this.yPos,100,100,null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void update()
    {
        if(this.direction.equals("right")){
            this.xPos += 4;
        }
        if(this.direction.equals("left")){
            this.xPos -= 4;
        }
        if(this.direction.equals("down")){
            this.yPos += 4;
        }
        if(this.direction.equals("up")){
            this.yPos -= 4;
        }
    }
}
