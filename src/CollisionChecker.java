import java.awt.*;

public class CollisionChecker {
    public boolean collisionCheck(int x1, int y1 ,int width1, int height1, int x2, int y2, int width2, int height2){
        int tw = width1;
        int th = height1;
        int rw = width2;
        int rh = height2;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = x1;
        int ty = y1;
        int rx = x2;
        int ry = y2;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }
}
