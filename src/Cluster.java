import java.util.ArrayList;

/**
 * Created by sri on 30/3/15.
 */
public class Cluster {
    ArrayList<Pixel> points; // Stores all the points in the cluster
    // Each element is a Pixel object
    Pixel cntr; // Centroid of all the points in the cluster
                // The centroid is calculated wrt the points in the cluster

    Cluster() {
        points = new ArrayList();
        cntr = new Pixel();
    }

    Cluster(ArrayList prevClust, Pixel centroid) {
        // prevClust is an array of all points that belong to a particular cluster
        // centroid is the centroid of all the points in the cluster sent
        points = prevClust;
        cntr = centroid;
    }

    Pixel calcCentroid() {
        // Calculates the centroids of the current cluster
        Pixel obj = new Pixel(0, 0); // Centroid is initialised to 0, 0
        int size = points.size();
        // To prevent divide by 0 errors, when the size of the cluster is 0, we change it to 1
        if(size == 0)
            size = 1;
        // The centroid formula we are using is
        // Sum of all x co-ordinates divided by number of points
        for(int i = 0; i < points.size(); i++) {
            Pixel temp = points.get(i);
            obj.i += temp.i;
            obj.j += temp.j;
        }
        obj.i = obj.i/ size;
        obj.j = obj.j/ size;
        cntr = obj;
        return obj;
    }

    static Pixel calcCentroid(ArrayList<Pixel> pix) {
        Pixel obj = new Pixel(0, 0);
        int size = pix.size();
        size = (size == 0 ? 1 : size);
        for(int i = 0; i < size; i++) {
            Pixel t = pix.get(i);
            obj.i += t.i;
            obj.j += t.j;
        }
        obj.i /= size;
        obj.j /= size;
        return obj;
    }

    void add(Pixel obj) {
        points.add(obj);
    }
}
