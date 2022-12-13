import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player2 extends Entity{

    int ability1 = x;
    int healthBar;
    boolean attacking;
    KeyControl keyH;
    HealthBar health = new HealthBar();
    FireBall fireball = new FireBall();
    KeyControlAbilities keyQ;

    public Player2(KeyControl keyH, int healthBar, KeyControlAbilities keyQ) {
        this.keyH = keyH;
        this.healthBar = healthBar;
        this.keyQ = keyQ;

        setDefaultValues();
        getAttackImage();
        getPlayer2Image();
    }

    public void setDefaultValues() {
        //PERHAPS USE 'WIDTH/2' AND 'HEIGHT/2' TO SPAWN IN MIDDLE NO MATTER THE RESOLUTION
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
        ability1x = 0;
        ability1y = 0;
    }

    public void getPlayer2Image (){

        try {
            up1Red = ImageIO.read(getClass().getResourceAsStream("res/boy_up_1 _red.png"));
            up2Red = ImageIO.read(getClass().getResourceAsStream("res/boy_up_2_red.png"));
            down1Red = ImageIO.read(getClass().getResourceAsStream("/res/boy_down_1_red.png"));
            down2Red = ImageIO.read(getClass().getResourceAsStream("/res/boy_down_2_red.png"));
            left1Red = ImageIO.read(getClass().getResourceAsStream("/res/boy_left_1_red.png"));
            left2Red = ImageIO.read(getClass().getResourceAsStream("/res/boy_left_2_red.png"));
            right1Red = ImageIO.read(getClass().getResourceAsStream("/res/boy_right_1_red.png"));
            right2Red = ImageIO.read(getClass().getResourceAsStream("/res/boy_right_2_red.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }


    public void getAttackImage(){
        try {
            attackUp1 = ImageIO.read(getClass().getResourceAsStream("res/boy_attack_up_1.png"));
            attackUp2 = ImageIO.read(getClass().getResourceAsStream("res/boy_attack_up_2.png"));
            attackDown1 = ImageIO.read(getClass().getResourceAsStream("res/boy_attack_down_1.png"));
            attackDown2 = ImageIO.read(getClass().getResourceAsStream("res/boy_attack_down_2.png"));
            attackLeft1 = ImageIO.read(getClass().getResourceAsStream("res/boy_attack_left_1.png"));
            attackLeft2 = ImageIO.read(getClass().getResourceAsStream("res/boy_attack_left_2.png"));
            attackRight1 = ImageIO.read(getClass().getResourceAsStream("res/boy_attack_right_1.png"));
            attackRight2 = ImageIO.read(getClass().getResourceAsStream("res/boy_attack_right_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update() {
        //ANIMATION WHILE STANDING STILL
        //if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
        //if (attacking = true) { //something is wrong here...

        if (keyQ.qPressed) { //Might need to change something here?
            playerAttack();


        }else if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }
        spriteCounter++;
        if (spriteCounter > 15) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void playerAttack() {

        spriteCounter++;

        if (spriteCounter <= 5){ //show attack image 1 during first five frames
            spriteNum = 1;
        }
        if (spriteCounter > 5 && spriteCounter <= 25){
            spriteNum = 2;
        }
        if (spriteCounter > 25){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }
    }



    public void drawRed(Graphics g) {

        BufferedImage imageRed = null;
        BufferedImage image1 = null;

        //Depending on players direction and attacking stage, a diffrent image is shown.
        switch(direction) {
            case "up":
                if (!attacking){
                    if(spriteNum == 1) {imageRed = up1Red;}
                    if(spriteNum == 2) {imageRed = up2Red;}
                }
                if (attacking){
                    if(spriteNum == 1) {image1 = attackUp1;}
                    if(spriteNum == 2) {image1 = attackUp2;}
                }
                break;
            case "down":
                if (!attacking){
                    if(spriteNum == 1) {imageRed = down1Red;}
                    if(spriteNum == 2) {imageRed = down2Red;}
                }
                if (attacking) {
                    if (spriteNum == 1) {image1 = attackDown1;}
                    if (spriteNum == 2) {image1 = attackDown2;}
                }
                break;
            case "left":
                if (!attacking){
                    if(spriteNum == 1) {imageRed = left1Red;}
                    if(spriteNum == 2) {imageRed = left2Red;}
                }
                if (attacking){
                    if(spriteNum == 1) {image1 = attackLeft1;}
                    if(spriteNum == 2) {image1 = attackLeft2;}
                }
                break;
            case "right":
                if (!attacking){
                    if(spriteNum == 1) {imageRed = right1Red;}
                    if(spriteNum == 2) {imageRed = right2Red;}
                }
                if (attacking){
                    if(spriteNum == 1) {image1 = attackRight1;}
                    if(spriteNum == 2) {image1 = attackRight2;}
                }
                break;
        }
        g.drawImage(imageRed, x, y, 48, 48, null);
        health.drawHealth(g,x,y-10,healthBar);
        g.drawImage(image1,x,y,48,48,null);

        if(keyQ.abilityPressed==true) {

            fireball.draw(g, x+ability1x, y+ability1y + 10);
            if(direction.equals("right")){
                ability1x+=4;
            }
            if(direction.equals("left")){
                ability1x--;
            }
            if(direction.equals("down")){
                ability1y++;
            }
            if(direction.equals("up")){
                ability1y--;
            }

        }

    }

}
