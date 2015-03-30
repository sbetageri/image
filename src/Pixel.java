import java.util.ArrayList;

/**
 * Created by sri on 27/3/15.
 */
public class Pixel {
    int i;
    int j;
    int c;

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
    public void display() {
        System.out.println(i + " , " + j);
    }

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

    int findClosestCentroid(ArrayList<Pixel> pix) {
        // Input : List of Centroids
        // Output : Index of the closest centroid
        int distance = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < pix.size(); i++) {
            int temp = dist(pix.get(i));
            if(temp < distance) {
                distance = temp;
                count = i;
            }
        }
        return count;
    }
}
