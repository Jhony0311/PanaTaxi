package co.hyphendated.panataxi;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import co.hyphendated.panataxi.ui.LocationFragment;
import co.hyphendated.panataxi.ui.DateHourFragment;
import co.hyphendated.panataxi.ui.DetailsFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(toolbar);
        setContentView(R.layout.activity_main);

        //Setting fragments
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragmentContainer, new LocationFragment(), "fragment_one");
        ft.add(R.id.fragmentContainer, new DateHourFragment(), "fragment_two");
        ft.add(R.id.fragmentContainer, new DetailsFragment(), "fragment_three");
        ft.commit();

        calcBtn = (FloatingActionButton) findViewById(R.id.calculateBtn);
    }

    public void setToolbar(Toolbar toolbar) {
        if(toolbar != null) {
            toolbar = (Toolbar) findViewById(R.id.toolbarActionbar);
            toolbar.setNavigationIcon(R.mipmap.ic_launcher);
            setSupportActionBar(toolbar);
        }
    }

    public void calcInit(View v) {
        Log.v("CALC", "INIT");
        LocationFragment fragmentLocation = (LocationFragment) getSupportFragmentManager().findFragmentByTag("fragment_one");
        DateHourFragment fragmentDateHour = (DateHourFragment) getSupportFragmentManager().findFragmentByTag("fragment_two");
        DetailsFragment fragmentDetails = (DetailsFragment) getSupportFragmentManager().findFragmentByTag("fragment_three");
        // Locaiton values
        //Log.v("CALC", fragmentLocation.origin.getName());
        //Log.v("CALC", fragmentLocation.destiny.getName());

        // DateHour Values
        //fragmentDateHour.daySelected;
        //fragmentDateHour.monthSelected;
        //fragmentDateHour.yearSelected;
        //fragmentDateHour.hoursSelected;
        //fragmentDateHour.minutesSelected;

        //Details values
        //Log.v("CALC", fragmentDetails.piqueraValue);
        //Log.v("CALC", fragmentDetails.passengersValue);
    }
}
