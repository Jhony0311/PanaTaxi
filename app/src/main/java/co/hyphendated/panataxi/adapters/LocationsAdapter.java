package co.hyphendated.panataxi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.hyphendated.panataxi.R;
import co.hyphendated.panataxi.models.Location;

/**
 * Created by JonathanMartin on 01/17/2016.
 */
public class LocationsAdapter extends ArrayAdapter<Location> {
    public LocationsAdapter(Context context, int resource, ArrayList<Location> items) {
        super(context, resource, items);
    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        Location location = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.location_view, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.locationName);
        name.setText(location.getName());

        return convertView;
    }
}
