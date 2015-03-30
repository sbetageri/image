import java.util.ArrayList;

/**
 * Created by sri on 27/3/15.
 */
public class kmeans {
    ArrayList<Pixel> arr; // Array of pixels

    int nClust;
    // Number of clusters to be obtained

    ArrayList cluster;
    /*
        Each cluster element stores the points that belong to that cluster
        The cluster number is merely the index of the cluster
        It is implemented using an ArrayList of ArrayLists

     */
    // Each element here is an ArrayList which is a cluster
    // The indexes of each element belonging to a cluster is stored here
    // The internal ArrayList is made up of pixels, defined earlier.

    ArrayList<Pixel> cntrds;
    // Each element is the centroid of the
    // The centroids of each cluster is stored here initially

    ArrayList<Pixel> nCntrds;
    // After running the algorithm once, the next centroids that are calculated are stored here

    kmeans(ArrayList pix, int numClust) {
        arr = pix;
        nClust = numClust;
        cluster = new ArrayList(nClust);
        /*
            Cluster is a 2D array
            The for loop creates an instance of an empty inner array and places it in the outer array
         */
        for(int i = 0; i < nClust; i++)
            cluster.add(new ArrayList());
        cntrds = new ArrayList(nClust);
        nCntrds = new ArrayList(nClust);
        setInitial(); // places the initial centroids
        initialCalc(); // Places the pixels in the corresponding clusters and recalculates the centroids
        // cluster will the clusters ready
        // cntrds will still hold the values of the initial points
        // nCntrds will have the new centroids for each cluster
        // clusterify(25);
    }

    void setInitial() {
        // Centroids are placed in the middle of the sample picture
        int offset = 200 / nClust;
        for(int i = 1; i <= nClust; i++) {
            cntrds.add(new Pixel(100, offset * i));
            // Sets the centroids initially along a line from the top left to the bottom right
            nCntrds.add(new Pixel(0, 0));
            // Initialises the next set of centroids to 0
        }
    }

    void initialCalc() {
        // First part goes through all the pixels and places it in the closest centroid's cluster
        for (int i = 0; i < arr.size(); i++) {
            // Goes through all the pixels
            Pixel obj = arr.get(i);
            int count = -1; // Used to keep track of the closest centroid
            int dist = Integer.MAX_VALUE; // Tracks the distance between the current pixel and current centroid
            // count stores the index of the centroid that is closest to current pixel
            for (int j = 0; j < cntrds.size(); j++) {
                // Checks the distance of each pixel with each centroid
                int temp = obj.dist(cntrds.get(j));
                if(temp < dist) {
                    dist = temp;
                    count = j;
                }
            }
            ArrayList local = (ArrayList)cluster.get(count); // The specific cluster is obtained from the 2D cluster
            local.add(obj); // The object is added to the inner array
            // Since the elements are being added for the first time,
            // We use add, otherwise, we need to make the change to
            // ArrayListObj.set(index, object);
        }
        // ***************************************************************
        // Second part, recalculates the centroids of the clusters.
        for (int i = 0; i < cluster.size(); i++) {
            ArrayList temp = (ArrayList)cluster.get(i);
            int x = 0;
            int y = 0;
            for (int j = 0; j < temp.size(); j++) {
                Pixel t = (Pixel)temp.get(j);
                x += t.i;
                y += t.j;
            }
            int size = temp.size();
            if(size == 0)
                size = 1;
            Pixel centroid = new Pixel(x / size, y / size);
            nCntrds.set(i, centroid);
        }
    }

    void setNewCentroids() {
        /*
            Need to recalculate all the centroids after each iteration of the k means algo
         */
        for(int i = 0; i < arr.size(); i++) {
            int dist = Integer.MAX_VALUE;
        }
    }

    boolean isSameCntrds() {
        /*
            Compares cntrds with nCntrds
            If the centroids are different, returns False
            Else returns true
         */
        for(int i = 0; i < cntrds.size(); i++) {
            Pixel a = cntrds.get(i);
            Pixel b = nCntrds.get(i);
            if (a.isSame(b))
                continue;
            else
                return false;
        }
        return true;
    }


   // void clusterify(int lim) {

        /*
            cluster.get(i) contains the points that belong to cluster ci,
            Taking all the points in that cluster, we find the centroid.
            After finding the centroids, we store the value in nCntrds
            once that is done, if the centroids are different, we
            continue with the next iteration.
            Else, we have reached saturation
         */
        /*
        while(lim-- > 0) {
            // Calculates the centroids from cluster
            for(int i = 0; i < cluster.size(); i++) {
                ArrayList points = (ArrayList)cluster.get(i);
                int x = 0, y = 0;
                for(int j = 0; j < points.size(); j++) {
                    pixel c = (pixel)points.get(i);
                    x += c.i;
                    y += c.j;
                }
                pixel obj = (pixel)nCntrds.get(i);
                int size = points.size();
                if(size == 0)
                    size = 1;
                obj.i = x / size;
                obj.j = y / size;
            }
        }
    } */
}
