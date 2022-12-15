import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

//MISSING IMPORTS
//INSTANCE PLAYER IN GAMEPANEL: Player player = new Player(this,keyH);
//IN GamePanel, remove code in 'update', REPLACE WITH player.update();
//REMOVE CODE IN 'draw', REPLACE WITH.
public class Player extends Entity {
    FireBall fireball;
    public int attackX;
    public int attackY;
    public int fireX;
    public int fireY;


    CollisionChecker collisionCheck = new CollisionChecker();
    boolean attacking;

    KeyControl keyH;
    HealthBar healthbar = new HealthBar();



    KeyControlAbilities keyQ;



    public Player(KeyControl keyH, KeyControlAbilities keyQ) {
        this.keyH = keyH;
        this.keyQ = keyQ;

        setDefaultValues();
        getPlayerImage();
        getAttackImage();
    }

    public void setDefaultValues() {
        //PERHAPS USE 'WIDTH/2' AND 'HEIGHT/2' TO SPAWN IN MIDDLE NO MATTER THE RESOLUTION
        x1 = 100;
        y1 = 100;
        speed = 4;
        health2 = 40;
        direction = "down";
        ability1x = 0;
        ability1y = 0;
        attackY = 0;
        attackX = 0;
        fireX = 0;
        fireY = 0;
    }


    public void collisionMapboundary(){
        if(collisionCheck.collisionCheck(x1,y1,10,35,0,0,20,48*16)==true){ //venstre væg
            System.out.println("hey");
            switch (direction){
                case"up":
                    y1+=4;
                    break;
                case "down":
                    y1-=4;
                    break;
                case"left":
                    x1+=4;
                    break;
                case"right":
                    x1-=4;
                    break;

            }
        }

        if(collisionCheck.collisionCheck(x1,y1,25,35,0,0,48*20,5)==true){ //øverste væg
            System.out.println("hey");
            switch (direction){
                case"up":
                    y1+=4;
                    break;
                case "down":
                    y1-=4;
                    break;
                case"left":
                    x1+=4;
                    break;
                case"right":
                    x1-=4;
                    break;

            }
        }
        if(collisionCheck.collisionCheck(x1,y1,25,35,920,0,48,48*16)==true){ //højre væg
            System.out.println("hey");
            switch (direction){
                case"up":
                    y1+=4;
                    break;
                case "down":
                    y1-=4;
                    break;
                case"left":
                    x1+=4;
                    break;
                case"right":
                    x1-=4;
                    break;

            }
        }

        if(collisionCheck.collisionCheck(x1,y1,25,35,0,770,48*20,50)==true){ //Sidste vandrette væg
            System.out.println("hey");
            switch (direction){
                case"up":
                    y1+=4;
                    break;
                case "down":
                    y1-=4;
                    break;
                case"left":
                    x1+=4;
                    break;
                case"right":
                    x1-=4;
                    break;

            }
        }

    }

    public void collisionObstacles(){
        if(collisionCheck.collisionCheck(x1,y1,25,35,366,75,25,20)==true){ // den lille ildkugle
            System.out.println("hey");
            switch (direction){
                case"up":
                    y1+=4;
                    break;
                case "down":
                    y1-=4;
                    break;
                case"left":
                    x1+=4;
                    break;
                case"right":
                    x1-=4;
                    break;

            }
        }
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

        //Map collision
        collisionObstacles();
        collisionMapboundary();



        if (keyQ.qPressed) { //Might need to change something here?
            playerAttack();


        }else if (keyH.upPressed == true) {
            direction = "up";
            y1 -= speed;
        } else if (keyH.downPressed == true) {
            direction = "down";
            y1 += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";
            x1 -= speed;
        } else if (keyH.rightPressed == true) {
            direction = "right";
            x1 += speed;
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

        if (spriteCounterAttack >= 15){ //show attack image 1 during first five frames
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



    public void draw(Graphics g) {

        BufferedImage image = null;
        BufferedImage image1 = null;

        //Depending on players direction and attacking stage, a diffrent image is shown.
        switch(direction) {
            case "up":
                if (!keyQ.qPressed){
                    if(spriteNum == 1) {image = up1;}
                    if(spriteNum == 2) {image = up2;}
                }
                if (keyQ.qPressed){
                    if(spriteNumAttack == 1) {image1 = attackUp1;}
                    if(spriteNumAttack == 2) {image1 = attackUp2;}
                }
                break;
            case "down":
                if (!keyQ.qPressed){
                    if(spriteNum == 1) {image = down1;}
                    if(spriteNum == 2) {image = down2;}
                }
                if (keyQ.qPressed) {
                    if (spriteNumAttack == 1) {image1 = attackDown1;}
                    if (spriteNumAttack == 2) {image1 = attackDown2;}
                }
                break;
            case "left":
                if (!keyQ.qPressed){
                    if(spriteNum == 1) {image = left1;}
                    if(spriteNum == 2) {image = left2;}
                }
                if (keyQ.qPressed){
                    if(spriteNumAttack == 1) {image1 = attackLeft1;}
                    if(spriteNumAttack == 2) {image1 = attackLeft2;}
                }
                break;
            case "right":
                if (!keyQ.qPressed){
                    if(spriteNum == 1) {image = right1;}
                    if(spriteNum == 2) {image = right2;}
                }
                if (keyQ.qPressed){
                    if(spriteNumAttack == 1) {image1 = attackRight1;}
                    if(spriteNumAttack == 2) {image1 = attackRight2;}
                }
                break;
        }
        g.drawImage(image, x1, y1, 48, 48, null);
        healthbar.drawHealth(g,x1,y1-10,health2);
        g.drawImage(image1,x1,y1,48,48,null);



        // ------- fireball ------- //
        if(keyQ.abilityPressed==true) {
            fireball = new FireBall();
            fireball.setDirection(direction);
            attackX = fireball.setxPos(x1+30);
            attackY = fireball.setyPos(y1+30);

            keyQ.abilityPressed = false;
        }
        int fireballspeed = 30;
        if (fireball != null){
            fireball.draw(g);
            if(fireball.direction.equals("right")){
                fireball.xPos += fireballspeed;
            }
            if(fireball.direction.equals("left")){
                fireball.xPos -= fireballspeed;
            }
            if(fireball.direction.equals("down")){
                fireball.yPos += fireballspeed;
            }
            if(fireball.direction.equals("up")){
                fireball.yPos -= fireballspeed;
            }
        }


    }
}


























