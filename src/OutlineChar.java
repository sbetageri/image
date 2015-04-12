import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by sri on 8/4/15.
 */
public class OutlineChar {
    BufferedImage image;
    int height;
    int width;

    OutlineChar(BufferedImage obj) throws IOException {
        image = obj;
        height = obj.getHeight();
        width = obj.getWidth();
        BufferedImage outline = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int i = 1; i < height - 1; i++)
            for(int j = 1; j < width - 1; j++) {
                if(isBoundaryPixel(j, i)) {
                    outline.setRGB(j, i, Color.BLACK.getRGB());
                } else {
                    outline.setRGB(j, i, Color.WHITE.getRGB());
                }
            }
        File border = new File("/home/sri/p/proj/trial/imgs/gaBORDER.bmp");
        ImageIO.write(outline, "bmp", border);
    }

    boolean isBoundaryPixel(int i, int j) {
        int[] box = new int[9];
        image.getRGB(i - 1, j - 1, 3, 3, box, 0, 3);
        if(box[4] == Color.black.getRGB()) {
            if(box[1] == Color.white.getRGB() || box[3] == Color.white.getRGB()
                    ||  box[5] == Color.white.getRGB() || box[7] == Color.white.getRGB())
                return true;
        }
        return false;
    }
}
