package mv2a.materialdesigntest;
public class RecycleBin {
    // Represents a Recycle Bin.
    private double latitude, longitude, id;
    public RecycleBin(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getID() {
        return this.id;
    }

    public void setID(double id) {
        this.id = id;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}