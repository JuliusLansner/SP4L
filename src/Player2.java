import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player2 extends Entity{

    KeyControl keyH;
    HealthBar healthbar = new HealthBar();
    FireBall fireball;
    KeyControlAbilities keyO;




    public Player2(KeyControl keyH, KeyControlAbilities keyO) {
        this.keyH = keyH;
        this.keyO = keyO;

        setDefaultValues();
        getPlayer2Image();
        getAttackImageAxe();
    }

    public void setDefaultValues() {
        //PERHAPS USE 'WIDTH/2' AND 'HEIGHT/2' TO SPAWN IN MIDDLE NO MATTER THE RESOLUTION
        x = 100;
        y = 100;
        speed = 4;
        health = 40;
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


    public void getAttackImageAxe(){
        try {
            attackUp1Red = ImageIO.read(getClass().getResourceAsStream("res/boy_axe_up_1_red.gif"));
            attackUp2Red = ImageIO.read(getClass().getResourceAsStream("res/boy_axe_up_2_red.gif"));
            attackDown1Red = ImageIO.read(getClass().getResourceAsStream("res/boy_axe_down_1_red.gif"));
            attackDown2Red = ImageIO.read(getClass().getResourceAsStream("res/boy_axe_down_2_red.gif"));
            attackLeft1Red = ImageIO.read(getClass().getResourceAsStream("res/boy_axe_left_1_red.gif"));
            attackLeft2Red = ImageIO.read(getClass().getResourceAsStream("res/boy_axe_left_2_red.gif"));
            attackRight1Red = ImageIO.read(getClass().getResourceAsStream("res/boy_axe_right_1_red.png"));
            attackRight2Red = ImageIO.read(getClass().getResourceAsStream("res/boy_axe_right_2_red.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update() {
        //ANIMATION WHILE STANDING STILL
        //if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
        //if (attacking = true) { //something is wrong here...

        if (keyO.oPressed) { //Might need to change something here?
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
        spriteCounterAttack++;

        if (spriteCounterAttack >= 15){ //show attack image 1 during first fifteen frames
            spriteNumAttack = 1;
        }
        if (spriteCounterAttack > 15 && spriteCounterAttack <= 30){
            spriteNumAttack = 2;
        }
        if (spriteCounterAttack > 30){
            spriteNumAttack = 1;
            spriteCounterAttack = 0;
            attacking = false;
        }
    }



    public void drawRed(Graphics g) {

        BufferedImage imageRed = null;
        BufferedImage imageRed1 = null;

        //Depending on players direction and attacking stage, a different image is shown.
        switch(direction) {
            case "up":
                if (!keyO.oPressed){
                    if(spriteNum == 1) {imageRed = up1Red;}
                    if(spriteNum == 2) {imageRed = up2Red;}
                }
                if (keyO.oPressed){
                    if(spriteNumAttack == 1) {imageRed1 = attackUp1Red;}
                    if(spriteNumAttack == 2) {imageRed1 = attackUp2Red;}
                }
                break;
            case "down":
                if (!keyO.oPressed){
                    if(spriteNum == 1) {imageRed = down1Red;}
                    if(spriteNum == 2) {imageRed = down2Red;}
                }
                if (keyO.oPressed) {
                    if (spriteNumAttack == 1) {imageRed1 = attackDown1Red;}
                    if (spriteNumAttack == 2) {imageRed1 = attackDown2Red;}
                }
                break;
            case "left":
                if (!keyO.oPressed){
                    if(spriteNum == 1) {imageRed = left1Red;}
                    if(spriteNum == 2) {imageRed = left2Red;}
                }
                if (keyO.oPressed){
                    if(spriteNumAttack == 1) {imageRed1 = attackLeft1Red;}
                    if(spriteNumAttack == 2) {imageRed1 = attackLeft2Red;}
                }
                break;
            case "right":
                if (!keyO.oPressed){
                    if(spriteNum == 1) {imageRed = right1Red;}
                    if(spriteNum == 2) {imageRed = right2Red;}
                }
                if (keyO.oPressed){
                    if(spriteNumAttack == 1) {imageRed1 = attackRight1Red;}
                    if(spriteNumAttack == 2) {imageRed1 = attackRight2Red;}
                }
                break;
        }
        g.drawImage(imageRed, x, y, 48, 48, null);
        healthbar.drawHealth(g,x,y-10,health);
        g.drawImage(imageRed1,x,y,48,48,null);

        // ------- fireball ------- //
        if(keyO.abilityPressed==true) {
            fireball = new FireBall();
            fireball.setDirection(direction);
            fireball.setxPos(x);
            fireball.setyPos(y + 10);

            keyO.abilityPressed = false;
        }

        if (fireball != null) fireball.draw(g);



    }

}
