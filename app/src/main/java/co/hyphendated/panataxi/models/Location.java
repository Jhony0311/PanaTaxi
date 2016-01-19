package co.hyphendated.panataxi.models;

/**
 * Created by Jonathan on 1/4/2016.
 */
public class Location {
    int id;
    int index;
    String name;
    String parent;
    String type;

    public Location() { }

    public int getId() { return id; }

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
