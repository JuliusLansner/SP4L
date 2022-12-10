import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MapMaker {


    private BufferedImage[] loadMapTiles(){
        BufferedImage[] tiles = new BufferedImage[10];
        try {
            tiles[0] = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tiles;
    }

    public void drawMap(Graphics g) throws IOException {
        loadMapTiles();

        g.drawImage(loadMapTiles()[0],0,0,48,48,null);
    }

}
