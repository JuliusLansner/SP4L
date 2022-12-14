import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class FireBall{

    public String direction = "";
    public int xPos;
    public int yPos;

    public FireBall(){
    }



    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int setxPos(int xPos) {
        this.xPos = xPos;
        return xPos;
    }

    public int setyPos(int yPos) {
        this.yPos = yPos;
        return yPos;
    }

    public void draw(Graphics g){



        BufferedImage[] pics = new BufferedImage[3];
        Random rn = new Random();

        try {

            pics[0] = ImageIO.read(getClass().getResourceAsStream("/res/Fireball1.gif"));
            pics[1] = ImageIO.read(getClass().getResourceAsStream("/res/Fireball2.gif"));
            pics[2] = ImageIO.read(getClass().getResourceAsStream("/res/Fireball3.gif"));

                g.drawImage(pics[rn.nextInt(3)],this.xPos,this.yPos,100,100,null);

                CollisionChecker collisionChecker = new CollisionChecker();
                if(collisionChecker.collisionCheck(this.xPos,this.yPos,100,100,Player.x,Player.y,48,48)==true){
                    System.out.println("hey");
                    Player.health-=1;
                }

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
