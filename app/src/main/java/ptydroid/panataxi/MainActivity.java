package ptydroid.panataxi;

import android.os.Bundle;
import android.util.Log;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the layout
        setContentView(R.layout.activity_main);

        //Setting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);

        Log.d("LOG", String.valueOf(toolbar));

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }



    }

}
