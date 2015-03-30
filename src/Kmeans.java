import com.sun.javafx.geom.PickRay;

import java.util.ArrayList;

/**
 * Created by sri on 30/3/15.
 */
public class Kmeans {
    ArrayList<Pixel> pix;   // Stores the pixel points that has to be clustered

    ArrayList<Cluster> group; // Stores the clusters for each point

    int numClust; // Stores the number of clusters

    ArrayList<Pixel> cntrds; // Stores the centroids before reclustering

    ArrayList<Pixel> nCntrds; // Stores the centroids after reclustering

    Kmeans() {
        numClust = 0;
        pix = null;
        cntrds = nCntrds = null;
        group = null;
    }

    Kmeans(ArrayList<Pixel> points, int n) {
        pix = points;
        numClust = n;
        int offset = 200 / n;
        group = new ArrayList<Cluster>(); // Creates an array of Cluster objects
        cntrds = new ArrayList<Pixel>();  // Creates an array of Pixel objects
        nCntrds = new ArrayList<Pixel>(); // Creates an array of Pixel objects
        for(int i = 0; i < numClust; i++) {
            cntrds.add(new Pixel(100, offset * i)); // Setting the initial centroids along the centre of the image
            nCntrds.add(new Pixel(0, 0));
        }
        for(int i = 0; i < numClust; i++)
            group.add(new Cluster());
    }
}
