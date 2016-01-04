package co.hyphendated.panataxi;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import co.hyphendated.panataxi.ui.LocationFragment;
import co.hyphendated.panataxi.ui.DateHourFragment;
import co.hyphendated.panataxi.ui.DetailsFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setToolbar(toolbar);
        setContentView(R.layout.activity_main);

        //Setting fragments
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragmentContainer, new LocationFragment(), "fragment_one");
        ft.add(R.id.fragmentContainer, new DateHourFragment(), "fragment_two");
        ft.add(R.id.fragmentContainer, new DetailsFragment(), "fragment_three");
        ft.commit();
    }

    public void setToolbar(Toolbar toolbar) {
        if(toolbar != null) {
            toolbar = (Toolbar) findViewById(R.id.toolbarActionbar);
            toolbar.setNavigationIcon(R.mipmap.ic_launcher);
            setSupportActionBar(toolbar);
        }
    }
}
