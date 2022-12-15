import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player2 extends Entity{
    CollisionChecker collisionCheck = new CollisionChecker();
    KeyControl keyH;
    HealthBar healthbar = new HealthBar();
    FireBall fireball;
    KeyControlAbilities keyO;
    Sound sound2 = new Sound();




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
        fireCount2 = 1;
    }

    public void collisionMapboundaryFireball(int fireX, int fireY){
        if(collisionCheck.collisionCheck(fireX,fireY,10,35,0,0,20,48*16)==true){ //venstre væg
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,25,35,0,0,48*20,5)==true){ //øverste væg
            fireball = null;
        }
        if(collisionCheck.collisionCheck(fireX,fireY,25,35,920,0,48,48*16)==true){ //højre væg
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,25,35,0,770,48*20,50)==true){ //Sidste vandrette væg
            fireball = null;
        }

    }

    public void collisionObstaclesFireball(int fireX, int fireY){
        int playerwidth = 20;
        int playerheight = 30;
        int wallwidth = 20;
        int wallheight = 20;
        if(collisionCheck.collisionCheck(fireX,fireY,25,35,366,75,25,20)==true){ // den lille ildkugle
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,120,100,wallwidth,wallheight)==true){
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,120,133,wallwidth,wallheight)==true){ // den lille ildkugle
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,84,100,wallwidth,wallheight)==true){ // den lille ildkugle
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,120,166,wallwidth,wallheight)==true){ // den lille ildkugle
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,84,166,wallwidth,wallheight)==true){ // den lille ildkugle
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,800,625,wallwidth,wallheight)==true){ // den lille ildkugle
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,764,625,wallwidth,wallheight)==true){ // den lille ildkugle
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,764,590,wallwidth,wallheight)==true){ // den lille ildkugle
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,764,558,wallwidth,wallheight)==true){ // den lille ildkugle
            fireball = null;
        }

        if(collisionCheck.collisionCheck(fireX,fireY,playerwidth,playerheight,800,558,wallwidth,wallheight)==true){ // den lille ildkugle
            fireball = null;
        }

    }

    public void collisionMapboundary(){
        if(collisionCheck.collisionCheck(x,y,10,35,0,0,20,48*16)==true){ //venstre væg
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

        if(collisionCheck.collisionCheck(x,y,25,35,0,0,48*20,5)==true){ //øverste væg
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
        if(collisionCheck.collisionCheck(x,y,25,35,920,0,48,48*16)==true){ //højre væg
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

        if(collisionCheck.collisionCheck(x,y,25,35,0,770,48*20,50)==true){ //Sidste vandrette væg
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

    }

    public void collisionObstacles(){
        int playerwidth = 20;
        int playerheight = 30;
        int wallwidth = 20;
        int wallheight = 20;
        if(collisionCheck.collisionCheck(x,y,25,35,366,75,25,20)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,120,100,wallwidth,wallheight)==true){
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,120,133,wallwidth,wallheight)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,84,100,wallwidth,wallheight)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,120,166,wallwidth,wallheight)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,84,166,wallwidth,wallheight)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,800,625,wallwidth,wallheight)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,764,625,wallwidth,wallheight)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,764,590,wallwidth,wallheight)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,764,558,wallwidth,wallheight)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,800,558,wallwidth,wallheight)==true){ // den lille ildkugle
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

        if(collisionCheck.collisionCheck(x,y,playerwidth,playerheight,800,593,wallwidth,wallheight)==true){
            //Question stuff here
        }
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
            playerDeathRed = ImageIO.read(getClass().getResourceAsStream("res/boy_left_1_red_death.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update() {
        //ANIMATION WHILE STANDING STILL
        //if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
        //if (attacking = true) { //something is wrong here...
collisionMapboundary();
collisionObstacles();

        playerDeath();



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
        //playSEMusic(2); // Could be used for SE. Sound file is crap though.
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

    public void playerDeath() {
        if (Player2.health == 0) {
            playerDeath = true;
            System.out.println("DEATH BY FIREBALL");
        }
    }

    public void playSEMusic(int i){
        sound2.setMusicFile(i);
        sound2.playMusic();
    }




    public void drawRed(Graphics g) {

        BufferedImage imageRed = null;
        BufferedImage imageRed1 = null;

        //Depending on players direction and attacking stage, a different image is shown.
        switch (direction) {
            case "up":
                if (!keyO.oPressed) {
                    if (spriteNum == 1) {
                        imageRed = up1Red;
                    }
                    if (spriteNum == 2) {
                        imageRed = up2Red;
                    }
                }
                if (keyO.oPressed) {
                    if (spriteNumAttack == 1) {
                        imageRed1 = attackUp1Red;
                    }
                    if (spriteNumAttack == 2) {
                        imageRed1 = attackUp2Red;
                    }
                }
                if (playerDeath == true) {
                    spriteNumDeath = 1;
                    if (spriteNumDeath == 1) {
                        imageRed = playerDeathRed;
                    }
                }
                break;
            case "down":
                if (!keyO.oPressed) {
                    if (spriteNum == 1) {
                        imageRed = down1Red;
                    }
                    if (spriteNum == 2) {
                        imageRed = down2Red;
                    }
                }
                if (keyO.oPressed) {
                    if (spriteNumAttack == 1) {
                        imageRed1 = attackDown1Red;
                    }
                    if (spriteNumAttack == 2) {
                        imageRed1 = attackDown2Red;
                    }
                }
                if (playerDeath == true) {
                    spriteNumDeath = 1;
                    if (spriteNumDeath == 1) {
                        imageRed = playerDeathRed;
                    }
                }
                break;
            case "left":
                if (!keyO.oPressed) {
                    if (spriteNum == 1) {
                        imageRed = left1Red;
                    }
                    if (spriteNum == 2) {
                        imageRed = left2Red;
                    }
                }
                if (keyO.oPressed) {
                    if (spriteNumAttack == 1) {
                        imageRed1 = attackLeft1Red;
                    }
                    if (spriteNumAttack == 2) {
                        imageRed1 = attackLeft2Red;
                    }
                }
                if (playerDeath == true) {
                    spriteNumDeath = 1;
                    if (spriteNumDeath == 1) {
                        imageRed = playerDeathRed;
                    }
                }
                break;
            case "right":
                if (!keyO.oPressed) {
                    if (spriteNum == 1) {
                        imageRed = right1Red;
                    }
                    if (spriteNum == 2) {
                        imageRed = right2Red;
                    }
                }
                if (keyO.oPressed) {
                    if (spriteNumAttack == 1) {
                        imageRed1 = attackRight1Red;
                    }
                    if (spriteNumAttack == 2) {
                        imageRed1 = attackRight2Red;
                    }
                }
                if (playerDeath == true) {
                    spriteNumDeath = 1;
                    if (spriteNumDeath == 1) {
                        imageRed = playerDeathRed;
                    }
                }
                break;
        }
        g.drawImage(imageRed, x, y, 48, 48, null);
        healthbar.drawHealth(g, x, y - 10, health);
        g.drawImage(imageRed1, x, y, 48, 48, null);


        // ------- fireball ------- //
        if (keyO.abilityPressed == true && fireCount2 > 0) {
            playSEMusic(1);
            fireball = new FireBall();
            fireball.setDirection(direction);
            fireball.setxPos(x + 30);
            fireball.setyPos(y + 30);

            keyO.abilityPressed = false;
        }
        int fireballspeed = 30;
        if (fireball != null) {
            fireball.draw(g);
            if (fireball.direction.equals("right")) {
                fireball.xPos += fireballspeed;
            }
            if (fireball.direction.equals("left")) {
                fireball.xPos -= fireballspeed;
            }
            if (fireball.direction.equals("down")) {
                fireball.yPos += fireballspeed;
            }
            if (fireball.direction.equals("up")) {
                fireball.yPos -= fireballspeed;
            }

            if(collisionCheck.collisionCheck(fireball.xPos,fireball.yPos,80,80,Entity.x1,Entity.y1,30,30)==true){
                Player2.health2-=4;
                fireball = null;

            }

            collisionMapboundaryFireball(fireball.xPos,fireball.yPos);
            collisionObstaclesFireball(fireball.xPos,fireball.yPos);

        }

        }
    }

    /*public void playerQ2(){
        if(Entity.fireCount2 = 0  && player2.x = collision1x ){
            Questions q = new Questions();
            q.askQuestionPlus(Entity.fireCount2);
        }
    }*/

