import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapMaker {


public MapMaker(Graphics g){

    }


    private BufferedImage[] loadMapTiles(){
         BufferedImage[]tiles = new BufferedImage[10];
        try {
            tiles[0] = ImageIO.read(getClass().getResourceAsStream("/tiles1/HelBane"));
            tiles[1] = ImageIO.read(getClass().getResourceAsStream("/tiles1/GulvtæppeHøjre.gif"));
            tiles[2] = ImageIO.read(getClass().getResourceAsStream("/tiles1/Gulvtæppevenstreside.gif"));
            tiles[3] = ImageIO.read(getClass().getResourceAsStream("/tiles1/rødfarve.gif"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         return tiles;
    }

    public void drawMap(Graphics g) throws IOException {
    loadMapTiles();
    File file = new File("maps/map01.txt");
    Scanner read = new Scanner(file);
    String mapInput ="";
    ArrayList<Integer>tileNumber = new ArrayList<Integer>();
    while(read.hasNextLine()) {
        tileNumber.add(read.nextInt());
    }

   g.drawImage(loadMapTiles()[0],0,0,48,48,null );


  }
}
