package com.jhony.panataxi.panataxi;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Flia Ortega on 03/02/14.
 */
public class DateHourFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static final String ARG_SECTION_NUMBER = "1";

    /**Input variables**/
    private Button setTimeButton;
    private Button setDateButton;
    private CheckBox checkBoxDate;
    private CheckBox checkBoxTime;
    private TextView currDateText;
    private TextView currTimeText;

    /**Variables**/
    private int valueDay;
    private int valueMonth;
    private int valueYear;
    private int valueHour;
    private int valueMinute;

    public DateHourFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.datehour_fragment, container, false);

        //Listeners for fragmentsPickers
        final TimePickerDialog.OnTimeSetListener timePickerListener;
        final DatePickerDialog.OnDateSetListener datePickerListener;

        timePickerListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view,
                                  int hourOfDay, int minute) {
                valueHour = hourOfDay;
                valueMinute = minute;

                currTimeText.setText(String.valueOf(valueHour)+":"+String.valueOf(valueMinute));
            }
        };

        datePickerListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet (DatePicker view,
                                   int year, int month, int day) {
                valueDay = day;
                valueMonth = month;
                valueYear = year;

                currDateText.setText(String.valueOf(valueDay)+"/"+String.valueOf(valueMonth)+"/"+String.valueOf(valueYear));
            }
        };

        setTimeButton = (Button)rootView.findViewById(R.id.setTime_btn);
        setDateButton = (Button)rootView.findViewById(R.id.setDate_btn);

        checkBoxDate = (CheckBox)rootView.findViewById(R.id.curentDate_chck);
        checkBoxTime = (CheckBox)rootView.findViewById(R.id.curentTime_chck);

        currDateText = (TextView)rootView.findViewById(R.id.currDate_value);
        currTimeText = (TextView)rootView.findViewById(R.id.currTime_value);

        //By default put buttons in disable
        setDateButton.setEnabled(false);
        setTimeButton.setEnabled(false);

        //By default put checkboxes in true
        checkBoxDate.setChecked(true);
        checkBoxTime.setChecked(true);

        //By default put set date & hour to current system values
        final Calendar c = Calendar.getInstance();
        valueDay = c.get(Calendar.DAY_OF_MONTH);
        valueMonth = c.get(Calendar.MONTH);
        valueYear = c.get(Calendar.YEAR);
        valueHour = c.get(Calendar.HOUR_OF_DAY);
        valueMinute = c.get(Calendar.MINUTE);

        currTimeText.setText(String.valueOf(valueHour)+":"+String.valueOf(valueMinute));
        currDateText.setText(String.valueOf(valueDay)+"/"+String.valueOf(valueMonth)+"/"+String.valueOf(valueYear));

        checkBoxDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(checkBoxDate.isChecked()) {
                    valueDay = c.get(Calendar.DAY_OF_MONTH);
                    valueMonth = c.get(Calendar.MONTH);
                    valueYear = c.get(Calendar.YEAR);
                    currDateText.setText(String.valueOf(valueDay)+"/"+String.valueOf(valueMonth)+"/"+String.valueOf(valueYear));
                    setDateButton.setEnabled(false);
                } else {
                    setDateButton.setEnabled(true);
                }
            }
        });

        checkBoxTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(checkBoxTime.isChecked()) {
                    valueHour = c.get(Calendar.HOUR_OF_DAY);
                    valueMinute = c.get(Calendar.MINUTE);
                    currTimeText.setText(String.valueOf(valueHour)+":"+String.valueOf(valueMinute));
                    setTimeButton.setEnabled(false);
                } else {
                    setTimeButton.setEnabled(true);
                }
            }
        });

        setTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newTimePickerFragment = new TimePickerFragment(timePickerListener);

                newTimePickerFragment.show(getFragmentManager(), "timePicker");
            }
        });

        setDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newDatePickerFragment = new DatePickerFragment(datePickerListener);

                newDatePickerFragment.show(getFragmentManager(), "datePicker");
            }
        });

        return rootView;
    }
}
