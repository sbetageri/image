import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by sri on 31/3/15.
 */
public class PixelCharacter {
    // Each character, in an image, is cropped and the
    // top left and bottom right pixel co-ordinate is stored in this class

    Pixel start;
    Pixel end;

    PixelCharacter() {
        start = new Pixel();
        end  = new Pixel();
    }

    PixelCharacter(Pixel a, Pixel b) {
        start = new Pixel(a);
        end = new Pixel(b);
    }

    void showPixels() {
        // Debugging method
        start.display();
        end.display();
    }

    ArrayList<Pixel> getCharPoints(BufferedImage img) {
        ArrayList<Pixel> obj = new ArrayList<Pixel>();
        for(int i = start.i; i <= end.i; i++) {
            for(int j = start.j; j <= end.j; j++) {
                Color c = new Color(img.getRGB(i, j));
                if(c.getRGB() == Color.BLACK.getRGB()) {
                    obj.add(new Pixel(i, j));
                }
            }
        }
        return obj;
    }
}
