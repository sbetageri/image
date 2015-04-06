import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sri on 27/3/15.
 */
public class Pixel {
    int i;// stores the x co-ordinate
    int j;// stores the y co-ordinate
    int c;// stores the color of the pixel

    Pixel() {
        i = j = 0;
    }

    Pixel(int a, int b) {
        i = a;
        j = b;
        c = -1;
    }

    Pixel(int a, int b, int col) {
        i = a;
        j = b;
        c = col;
    }

    Pixel(Pixel obj) {
        i = obj.i;
        j = obj.j;
        c = obj.c;
    }

    public void display() {
        System.out.println(i + " , " + j);
    }

//    static boolean isCharPix(Pixel obj) {
        // Input : Pixel object
        // Checks if the pixel is part of a character or not, basic color check for now
        // Output : True if color is black
//    }

    int dist(Pixel b) {
        int x = Math.abs(i - b.i);
        int y = Math.abs(j - b.j);
        int d = (int)Math.sqrt(x * x + y * y);
        return d;
    }

    boolean isSame(Pixel a) {
        if( i == a.i && j == a.j)
            return true;
        return false;
    }

    int findClosestCentroid(ArrayList<Pixel> centroids) {
        // Input : List of Centroids
        // Output : Index of the closest centroid
        int distance = Integer.MAX_VALUE;
        int count = 0; // Index of the closest centroid
        for(int i = 0; i < centroids.size(); i++) {
            int temp = dist(centroids.get(i));
            if(temp < distance) {
                distance = temp;
                count = i;
            }
        }
        return count;
    }
}
