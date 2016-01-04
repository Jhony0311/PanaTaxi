package co.hyphendated.panataxi.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import co.hyphendated.panataxi.R;
import co.hyphendated.panataxi.models.Location;

public class LocationFragment extends Fragment {

    private AutoCompleteTextView originEditText, destinyEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_location, container, false);
        Firebase.setAndroidContext(getActivity());
        uiInit(root);
        getData();
        return root;
    }

    public void uiInit(View root) {
        originEditText = (AutoCompleteTextView) root.findViewById(R.id.origin_input);
        destinyEditText = (AutoCompleteTextView) root.findViewById(R.id.destiny_input);
    }

    public void getData() {
        Firebase locationsData = new Firebase("https://panataxihyphenated.firebaseio.com/locations");

        locationsData.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                System.out.println(dataSnapshot.getValue());
                Location location = dataSnapshot.getValue(Location.class);
                //Log.v("LOCATION", location.getName());
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
