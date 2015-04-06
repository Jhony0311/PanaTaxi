package ptydroid.panataxi;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Jonathan on 3/26/2015.
 */
public class Sector extends RealmObject {
    @PrimaryKey
    private int id;

    private String name;
}
