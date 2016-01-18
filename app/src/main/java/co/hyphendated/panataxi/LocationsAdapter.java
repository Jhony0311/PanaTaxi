package co.hyphendated.panataxi;

import android.content.Context;
import android.widget.ArrayAdapter;

import co.hyphendated.panataxi.models.Location;

/**
 * Created by JonathanMartin on 01/17/2016.
 */
public class LocationsAdapter extends ArrayAdapter<Location> {
    Context context;
    int layoutResourceId;
    Location data[] = null;

    public LocationsAdapter(Context context, int layoutResourceId, Location[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
}
