/**
 * Created by sri on 27/3/15.
 */
public class pixel {
    int i;
    int j;
    int c;

    pixel() {
        i = j = 0;
    }

    pixel(int a, int b) {
        i = a;
        j = b;
        c = -1;
    }

    pixel(int a, int b, int col) {
        i = a;
        j = b;
        c = col;
    }
    public void display() {
        System.out.println(i + " , " + j);
    }

    int dist(pixel b) {
        int x = Math.abs(i - b.i);
        int y = Math.abs(j - b.j);
        int d = (int)Math.sqrt(x * x + y * y);
        return d;
    }

    boolean isSame(pixel a) {
        if( i == a.i && j == a.j)
            return true;
        return false;
    }
}
