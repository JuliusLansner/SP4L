

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

//MISSING IMPORTS
//INSTANCE PLAYER IN GAMEPANEL: Player player = new Player(this,keyH);
//IN GamePanel, remove code in 'update', REPLACE WITH player.update();
//REMOVE CODE IN 'draw', REPLACE WITH.
public class Player extends Entity {
    int ability1 = x;
    int healthBar;

    boolean collisionOn = false;
    CollisionChecker collisionCheck = new CollisionChecker();
    boolean attacking;
    KeyControl keyH;
    HealthBar health = new HealthBar();

    FireBall fireball = new FireBall();
    KeyControlAbilities keyQ;

    public Player(KeyControl keyH, int healthBar, KeyControlAbilities keyQ) {
        this.keyH = keyH;
        this.healthBar = healthBar;
        this.keyQ = keyQ;

        setDefaultValues();
        getAttackImage();
        getPlayerImage();

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

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/boy_right_2.png"));

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
        if(collisionCheck.collisionCheck(x,y,48,48,366,75,30,25)==true){
            System.out.println("hey");
            switch (direction){
                case"up":
                    y+=4;
                    break;
                case "down":
                    y-=4;
                    break;
                case"left":
                    x+=4;
                    break;
                case"right":
                    x-=4;
                    break;

            }
        }

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



    public void draw(Graphics g) {

        BufferedImage image = null;
        BufferedImage image1 = null;

        //Depending on players direction and attacking stage, a diffrent image is shown.
        switch(direction) {
            case "up":
                if (!attacking){
                    if(spriteNum == 1) {image = up1;}
                    if(spriteNum == 2) {image = up2;}
                }
                if (attacking){
                    if(spriteNum == 1) {image1 = attackUp1;}
                    if(spriteNum == 2) {image1 = attackUp2;}
                }
                break;
            case "down":
                if (!attacking){
                    if(spriteNum == 1) {image = down1;}
                    if(spriteNum == 2) {image = down2;}
                }
                if (attacking) {
                    if (spriteNum == 1) {image1 = attackDown1;}
                    if (spriteNum == 2) {image1 = attackDown2;}
                }
                break;
            case "left":
                if (!attacking){
                    if(spriteNum == 1) {image = left1;}
                    if(spriteNum == 2) {image = left2;}
                }
                if (attacking){
                    if(spriteNum == 1) {image1 = attackLeft1;}
                    if(spriteNum == 2) {image1 = attackLeft2;}
                }
                break;
            case "right":
                if (!attacking){
                    if(spriteNum == 1) {image = right1;}
                    if(spriteNum == 2) {image = right2;}
                }
                if (attacking){
                    if(spriteNum == 1) {image1 = attackRight1;}
                    if(spriteNum == 2) {image1 = attackRight2;}
                }
                break;
        }
        g.drawImage(image, x, y, 48, 48, null);
        health.drawHealth(g,x,y-10,healthBar);
        g.drawImage(image1,x,y,48,48,null);

        if(keyQ.abilityPressed==true) {

                fireball.draw(g, ability1x=x, ability1y=y + 10);

                if(direction.equals("right")){

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


























