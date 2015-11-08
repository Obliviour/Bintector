package mv2a.materialdesigntest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Make only ONE instance of this class. This represents your database for proof of
// concept.
public class RecycleBinLocations {
    private ArrayList<RecycleBin> locations = new ArrayList<RecycleBin>();

    /**
     * Sorts top 10 results by distance.
     * @param curLat is user's current latitude
     * @param curLong is user's current longitude
     * @return arraylist of size 10 OR LESS that is sorted from least to most distance
     */
    public ArrayList<RecycleBin> getTopTenSortedResults(double curLat, double curLong) {
        final double cLat = curLat;
        final double cLong = curLong;
        ArrayList<RecycleBin> ret = new ArrayList<RecycleBin>();
        for (RecycleBin b : locations) {
            final double latDiff = Math.abs(curLat - b.getLatitude());
            final double lonDiff = Math.abs(curLong - b.getLongitude());
            if (latDiff <= (1 / 60.0) && lonDiff <= (1 / 60.0)) {
                ret.add(b);
            }
        }
        int limit = ret.size();
        Collections.sort(ret, new Comparator<RecycleBin>() {
            public int compare(RecycleBin a, RecycleBin b) {
                double aDist = Math.pow(a.getLatitude() - cLat, 2) + Math.pow(a.getLongitude() - cLong, 2);
                double bDist = Math.pow(b.getLatitude() - cLat, 2) + Math.pow(b.getLongitude() - cLong, 2);
                return Double.compare(aDist, bDist);
            }
        });
        if (ret.size() < 10) {
            limit = ret.size();
        } else {
            limit = 10;
        }

        ArrayList<RecycleBin> r = new ArrayList<RecycleBin>();

        for (int i = 0; i < limit; i++) {
            r.add(ret.get(i));
        }

        return r;
    }

    /**
     * Adds a recyclebin to the backing array list.
     * @param lat is the latitude of recycle bin
     * @param lon is the longitude of recycle bin
     */
    public void addRecycleBin(double lat, double lon) {
        locations.add(new RecycleBin(lat, lon));
    }
}
