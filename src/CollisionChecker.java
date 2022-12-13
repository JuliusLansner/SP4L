import java.awt.*;

public class CollisionChecker {
    public boolean collisionCheck(Rectangle rect1, Rectangle rect2){
        if(rect1.intersects(rect2)){
            return true;
        }
            return false;
    }
}
