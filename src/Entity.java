
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public static int x1, y1;
    public static int x, y;

    public int ability1x;
    public int ability1y;
    public int speed;
    public static int health;
    public static int health2;
    public boolean attacking = false;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public BufferedImage up1Red, up2Red, down1Red, down2Red, left1Red, left2Red, right1Red, right2Red;
    public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
    public BufferedImage attackUp1Red, attackUp2Red, attackDown1Red, attackDown2Red, attackLeft1Red, attackLeft2Red, attackRight1Red, attackRight2Red;
    public String direction;

    public int spriteCounter = 0;
    public int spriteCounterAttack = 0;
    public int spriteNum = 1;
    public int spriteNumAttack = 1;

}
