package co.hyphendated.panataxi.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import co.hyphendated.panataxi.R;

public class DetailsFragment extends Fragment {

    private SwitchCompat piqueraSwitch;
    private SeekBar passengersSeekBar;
    private TextView passengersTextView;

    public boolean piqueraValue = false;
    public int passengersValue = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_details, container, false);
        // Init ui elements and behaviors
        uiInit(root);
        return root;
    }

    public void uiInit(View root) {
        passengersSeekBar = (SeekBar) root.findViewById(R.id.passengersInput);
        piqueraSwitch = (SwitchCompat) root.findViewById(R.id.piqueraInput);
        passengersTextView = (TextView) root.findViewById(R.id.passengersText);

        passengersTextView.setText("1");
        passengersSeekBar.setProgress(1);
        passengersSeekBar.setMax(5);

        passengersSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(fromUser) {
                            passengersValue = progress;
                            passengersTextView.setText(String.valueOf(passengersValue));
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        if(seekBar.getProgress() < 1) {
                            seekBar.setProgress(1);
                            passengersTextView.setText(String.valueOf(seekBar.getProgress()));
                        }
                    }
                }
        );

        piqueraSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        piqueraValue = isChecked;
                    }
                }
        );
    }
}
