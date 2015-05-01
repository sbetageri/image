import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sri on 10/4/15.
 */
// Will receive an ArrayList of black points
public class Grid {

    void drawGrid(BufferedImage op,int sX, int sY, int gridX, int gridY, int hDist, int vDist){
        // sX and sY are the starting coordinates of the first grid
        // plots the
        for(int i = 0; i < hDist; i++) {
            op.setRGB(sX + gridX * hDist + i, sY + gridY * vDist, Color.yellow.getRGB());
            op.setRGB(sX + gridX * hDist + i, sY + (gridY + 1) * vDist, Color.yellow.getRGB());
        }
        for(int i = 0; i < vDist; i++) {
            op.setRGB(sX + gridX * hDist, sY + gridY * vDist + i, Color.yellow.getRGB());
            op.setRGB(sX + (gridX + 1) * hDist, sY + gridY * vDist + i, Color.yellow.getRGB());
        }
    }

    Grid(ArrayList<Pixel> pix, int height, int width) throws IOException {
        Pixel top = new Pixel(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Pixel bottom = new Pixel(Integer.MIN_VALUE, Integer.MIN_VALUE);
        BufferedImage op = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < pix.size(); i++) {
            Pixel temp = pix.get(i);
            if (temp.i < top.i)
                top.i = temp.i;
            if (temp.j < top.j)
                top.j = temp.j;
            if (temp.i > bottom.i)
                bottom.i = temp.i;
            if (temp.j > bottom.j)
                bottom.j = temp.j;
            op.setRGB(temp.i, temp.j, Color.WHITE.getRGB());
        }
        for(int i = 0; i < pix.size(); i++) {
            Pixel temp = pix.get(i);
            System.out.println("Grid X : " + temp.i / 20);
            System.out.println("Grid Y : " + temp.j / 20);
            int gridX, gridY;
            int hDist = (bottom.i - top.i) / 20; // Horizontal distance between extreme pixels
            int vDist = (bottom.j - top.j) / 20;
            gridX = (temp.i - top.i) / hDist;
            gridY = (temp.j - top.j) / vDist;
            drawGrid(op, top.i, top.j, gridX, gridY, hDist, vDist);
        }
        /*
        int hDist = (bottom.i - top.i) / 20; // Horizontal distance between extreme pixels
        int vDist = (bottom.j - top.j) / 20;
        for(int i = top.i - hDist; i <= bottom.i + hDist; i += hDist) {
            for(int j = top.j - vDist; j <= bottom.j + vDist; j++) {
                op.setRGB(i, j, Color.GREEN.getRGB());
            }
        }
        for(int i = top.i - hDist; i <= bottom.i + hDist; i++) {
            for(int j = top.j - vDist; j <= bottom.j + vDist; j += vDist) {
                op.setRGB(i, j, Color.GREEN.getRGB());
            }
        }
        for(int i = top.i - hDist; i <= bottom.i + hDist; i += hDist) {
            for(int j = top.j - vDist; j <= bottom.j + vDist; j += vDist) {
                op.setRGB(i, j, Color.WHITE.getRGB());
            }
        }
        */
        File out = new File("/home/sri/p/proj/trial/imgs/grid.bmp");
        ImageIO.write(op, "bmp",out);
    }
}
