package cscd212classes.lab2;

public class Television implements Comparable<Television> {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make){
        if (model == null || make == null || model.isEmpty() || make.isEmpty() || screenSize < 32 || resolution < 720)
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

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution){
        if (model == null || make == null || model.isEmpty() || make.isEmpty() || screenSize < 32 || resolution < 720)
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
    public boolean equals(final Object o){
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
    public int compareTo(final Television another){
        if (another == null)
            throw new IllegalArgumentException("null parameter in the compareTo method");

        int makeCmp = this.make.compareTo(another.getMake());
        int modelCmp = this.model.compareTo(another.getModel());

        if (makeCmp != 0)
            return this.make.compareTo(another.getMake());
        else if (modelCmp != 0)
            return this.model.compareTo(another.getModel());

        return this.screenSize - another.getScreenSize();
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