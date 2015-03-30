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
        // Input : List of points
        //         Number of clusters
        // Output : Initialises pix, group, numClust, cntrds
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
        for(int i = 0; i < pix.size(); i++) {
            // Finds the centroid that is closest to that point
            // The index is then used to store the point in the corresponding cluster
            Pixel p = pix.get(i);
            int index = p.findClosestCentroid(cntrds);
            Cluster temp = group.get(index);
            temp.add(p);
            // group will contain a list of clusters
            // each cluster will have a list of points and a centroid
        }
        findNewCentroids();
        run(50);
    }

    void run(int k) {
        // Uses cntrds, nCntrds and points and group
        if(!isSame() && k >= 0) {
            for(int i = 0; i < nCntrds.size(); i++) {
                // cntrds will hold the values of the new centroids
                cntrds.set(i, nCntrds.get(i));
            }
            reCluster();
            k--;
        }
    }

    void reCluster() {
        // After the new centroids are found
        // All the points are placed in new clusters.
        group = new ArrayList<Cluster>();
        for(int i = 0; i < numClust; i++)
            group.add(new Cluster());
        for(int i = 0; i < pix.size(); i++) {
            Pixel obj = pix.get(i);
            int index = obj.findClosestCentroid(cntrds);
            Cluster local = group.get(index);
            local.add(obj);
        }
        findNewCentroids();
    }

    void findNewCentroids() {
        // Given the current set of pixels that form a cluster
        // A new centroid is calculated and stored in nCntrds
        for(int i = 0; i < group.size(); i++) {
            nCntrds.set(i, group.get(i).calcCentroid());
        }
    }

    boolean isSame() {
        // Checks if the centroids of both cntrds and nCntrds are the same
        for(int i = 0; i < cntrds.size(); i++)
            if(cntrds.get(i) != nCntrds.get(i))
                return false;
        return true;
    }

}
