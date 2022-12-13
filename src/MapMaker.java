import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapMaker {

    private BufferedImage[] loadMapTiles(){
        BufferedImage[] tiles = new BufferedImage[10];
        try {
            tiles[0] = ImageIO.read(getClass().getResourceAsStream("/tiles/HelBane.gif"));
            tiles[1] = ImageIO.read(getClass().getResourceAsStream("/tiles/rødfarve.gif"));
            tiles[2] = ImageIO.read(getClass().getResourceAsStream("tiles/Wall.gif"));
            tiles[3] = ImageIO.read(getClass().getResourceAsStream("tiles/testRock.gif"));
            tiles[4] = ImageIO.read(getClass().getResourceAsStream("tiles/testFlame.gif"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tiles;
    }

    public void drawMap(Graphics g) throws IOException {
        loadMapTiles();
        
        g.drawImage(loadMapTiles()[0],0,0,48*20,48*16,null);
        g.drawImage(loadMapTiles()[2],150,150,6*6,6*6,null);
        g.drawImage(loadMapTiles()[3],150,650,6*6,6*6,null);
        g.drawImage(loadMapTiles()[3],800,150,6*6,6*6,null);
        g.drawImage(loadMapTiles()[3],800,650,6*6,6*6,null);
        g.drawImage(loadMapTiles()[4],366,75,6*6,6*6,null);

        }




}
