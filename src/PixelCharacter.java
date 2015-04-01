/**
 * Created by sri on 31/3/15.
 */
public class PixelCharacter {
    // Each character, in an image, is cropped and the
    // top left and bottom right pixel co-ordinate is stored in this class
    // ???????????????????????????????? Will inheriting from Pixel solve this issue????
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
}
