package co.hyphendated.panataxi.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

import co.hyphendated.panataxi.LocationsAdapter;
import co.hyphendated.panataxi.R;
import co.hyphendated.panataxi.models.Location;

public class LocationFragment extends Fragment {

    private AppCompatSpinner originSpinner, destinySpinner;
    private Firebase locationsData;
    private String firebaseUrl = "https://panataxihyphenated.firebaseio.com";
    private String firebaseChild = "locations";

    ArrayList<Location> locationsList = new ArrayList<Location>();
    LocationsAdapter adapter = new LocationsAdapter(getActivity(), locationsList);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_location, container, false);
        Firebase.setAndroidContext(getActivity());
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
        uiInit(root);
        getData();
        return root;
    }

    public void uiInit(View root) {
        originSpinner = (AppCompatSpinner) root.findViewById(R.id.origin_input);
        destinySpinner = (AppCompatSpinner) root.findViewById(R.id.destiny_input);
        originSpinner.setAdapter(adapter);
        destinySpinner.setAdapter(adapter);
    }

    public void getData() {
        locationsData = new Firebase(firebaseUrl).child(firebaseChild);

        locationsData.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Location locationItem = dataSnapshot.getValue(Location.class);
                adapter.add(locationItem);
                //Log.v("LOCATION", locationItem.getName());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
