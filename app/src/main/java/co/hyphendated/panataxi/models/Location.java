package co.hyphendated.panataxi.models;

/**
 * Created by Jonathan on 1/4/2016.
 */
public class Location {
    private int id;
    private int index;
    private String name;
    private String parent;
    private String type;

    public Location() {

    }

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public String getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }
}
