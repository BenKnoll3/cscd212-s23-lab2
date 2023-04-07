package cscd212classes.lab2;

public class Television implements Comparable<Television> {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(String model, boolean smart, int screenSize, int resolution, String make){
        if (model.isEmpty() || make.isEmpty() || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");

        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.make = make;
        this.resolution = resolution;
        if (this.resolution == 2160)
            this.fourK = true;
        else
            this.fourK = false;
    }

    public Television(String make, String model, boolean smart, int screenSize, int resolution){
        if (model.isEmpty() || make.isEmpty() || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");


        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.make = make;
        this.resolution = resolution;
        if (this.resolution == 2160)
            this.fourK = true;
        else
            this.fourK = false;
    }

    @Override
    public String toString(){
        if (this.smart && this.fourK)
            return this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with " + this.resolution + " resolution";
        else if (this.fourK)
            return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with 4K resolution";
        else if (this.smart)
            return this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with " + this.resolution + " resolution";
        else
            return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with " + this.resolution + " resolution";
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        else if (o == null)
            return false;
        else if (!(o instanceof Television))
            return false;

        Television one = (Television)o;
        if (one.getMake().compareTo(this.make) != 0)
            return false;
        else if (one.getModel().compareTo(this.model) != 0)
            return false;
        else if (one.getResolution() != this.resolution)
            return false;
        else if (one.getScreenSize() != this.screenSize)
            return false;

        return true;
    }
    @Override
    public int hashCode(){
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }
    @Override
    public int compareTo(Television another){
        if (this.make.compareTo(another.getMake()) != 0)
            return this.make.compareTo(another.getMake());
        else if (this.model.compareTo(another.getModel()) != 0)
            return this.model.compareTo(another.getModel());

        return Integer.compare(this.screenSize,another.getScreenSize());
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getResolution() {
        return this.resolution;
    }

    public int getScreenSize() {
        return this.screenSize;
    }
}