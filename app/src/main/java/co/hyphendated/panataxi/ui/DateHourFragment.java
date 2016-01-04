package co.hyphendated.panataxi.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;
import java.util.Calendar;

import co.hyphendated.panataxi.R;

public class DateHourFragment extends DialogFragment {

    private CheckBox timeCheckbox, dateCheckbox;
    private TextView timeTextView, dateTextView;

    private Calendar calendar = Calendar.getInstance();
    public int minutesSelected, hoursSelected, daySelected, monthSelected, yearSelected;
    public String AMPM;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_date_time, container, false);
        uiInit(root);
        return root;
    }

    public void uiInit(View root) {
        timeCheckbox = (CheckBox) root.findViewById(R.id.currTimeCheckBox);
        dateCheckbox = (CheckBox) root.findViewById(R.id.currDateCheckBox);

        timeTextView = (EditText) root.findViewById(R.id.timeInput);
        timeTextView.setClickable(false);
        setCurrentTime();

        timeCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    setCurrentTime();
                    timeTextView.setFocusable(false);
                    timeTextView.setClickable(false);
                } else {
                    timeTextView.setFocusable(true);
                    timeTextView.setClickable(true);
                }
            }
        });

        dateTextView = (TextView) root.findViewById(R.id.dateInput);
        setCurrentDate();

        dateTextView.setText(daySelected + "/" + monthSelected + "/" + yearSelected);

        dateCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                        setCurrentDate();
                        dateTextView.setFocusable(false);
                        dateTextView.setClickable(false);
                    } else {
                        dateTextView.setFocusable(true);
                        dateTextView.setClickable(true);
                    }
                }
            }
        );

        timeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((TextView) v).isClickable()) {
                    showTimePickerDialog().show();
                }
            }
        });

        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((TextView) v).isClickable()) {
                    showDatePickerDialog().show();
                }
            }
        });

        timeTextView.setFocusable(false);
        timeTextView.setClickable(false);
        dateTextView.setFocusable(false);
        dateTextView.setClickable(false);
    }

    public Dialog showTimePickerDialog() {
        Log.d("DIALOG", "TIME DIALOG SHOW");
        return new TimePickerDialog(getActivity(), setTime, hoursSelected, minutesSelected, false);
    }

    public Dialog showDatePickerDialog() {
        Log.d("DIALOG", "DATE DIALOG SHOW");
        int month = monthSelected - 1;
        return new DatePickerDialog(getActivity(), setDate, yearSelected, month, daySelected);
    }

    protected DatePickerDialog.OnDateSetListener setDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            yearSelected = year;
            monthSelected = monthOfYear + 1;
            daySelected = dayOfMonth;
            String date = String.format("%d/%d/%d", daySelected, monthSelected, yearSelected);
            dateTextView.setText(date);
        }
    };

    protected TimePickerDialog.OnTimeSetListener setTime = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            minutesSelected = minute;
            hoursSelected = calendar.get(calendar.HOUR);
            if(calendar.get(Calendar.AM_PM) == 1) {
                AMPM = "PM";
            } else {
                AMPM = "AM";
            }
            String time = String.format("%02d:%02d", hoursSelected, minutesSelected) + AMPM;
            timeTextView.setText(time);
        }
    };

    public void setCurrentDate() {
        calendar = Calendar.getInstance();
        daySelected = calendar.get(calendar.DAY_OF_MONTH);
        monthSelected = calendar.get(calendar.MONTH) + 1;
        yearSelected = calendar.get(Calendar.YEAR);
        String date = String.format("%d/%d/%d", daySelected, monthSelected, yearSelected);
        dateTextView.setText(date);
    }

    public void setCurrentTime() {
        calendar = Calendar.getInstance();
        minutesSelected = calendar.get(calendar.MINUTE);
        hoursSelected = calendar.get(calendar.HOUR);
        if(calendar.get(Calendar.AM_PM) == 1) {
            AMPM = "PM";
        } else {
            AMPM = "AM";
        }
        String time = String.format("%02d:%02d", hoursSelected, minutesSelected) + AMPM;
        timeTextView.setText(time);
    }
}
