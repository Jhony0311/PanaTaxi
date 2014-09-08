package com.jhony.panataxi.panataxi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by Flia Ortega on 03/02/14.
 */
public class DetailsFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static final String ARG_SECTION_NUMBER = "2";

    /**Input variables**/
    private SeekBar passengersInput;
    private TextView passengersQty;
    private ToggleButton taxiCallInput;

    /**Variables**/
    public int passengers = 1;
    public boolean taxiCall = true;


    public DetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.details_fragment, container, false);
        passengersInput = (SeekBar)rootView.findViewById(R.id.passenger_seekbar);
        passengersQty = (TextView)rootView.findViewById(R.id.passenger_qty);
        passengersQty.setText("1");

        taxiCallInput = (ToggleButton)rootView.findViewById(R.id.piquera_btn);

        taxiCallInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (taxiCallInput.isChecked()) {
                    taxiCall = true;
                    Log.d("TAXI CALL", String.valueOf(taxiCall));
                } else {
                    taxiCall = false;
                    Log.d("TAXI CALL", String.valueOf(taxiCall));
                }
            }
        });

        //taxiCall = taxiCallInput

        passengersInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                passengers = passengersInput.getProgress();
                if(passengers == 0)
                {
                    passengersInput.setProgress(1);
                    passengers = passengersInput.getProgress();
                }
                passengersQty.setText(String.valueOf(passengers));
                //Log.d("DEBUG", String.valueOf(passengers));
            }
        });

        return rootView;
    }
}
