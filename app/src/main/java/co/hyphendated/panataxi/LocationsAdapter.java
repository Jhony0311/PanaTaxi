package co.hyphendated.panataxi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.hyphendated.panataxi.models.Location;

/**
 * Created by JonathanMartin on 01/17/2016.
 */
public class LocationsAdapter extends ArrayAdapter<Location> {
    Context context;

    public LocationsAdapter(Context context, ArrayList data) {
        super(context, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Location location = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location_view, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.locationName);
        // Populate the data into the template view using the data object
        name.setText(location.getName());
        // Return the completed view to render on screen
        return convertView;
    }
}
