package mv2a.materialdesigntest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.software.shell.fab.ActionButton;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Locationn locationN;
    private RecycleBinLocations recycleBinLocations;
    private MapsActivity map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_appbar);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
            getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


        ActionButton actionButton = (ActionButton) findViewById(R.id.action_button);
        actionButton.setButtonColor(getResources().getColor(R.color.fab_material_lime_500));
        actionButton.setButtonColorPressed(getResources().getColor(R.color.fab_material_lime_900));
        actionButton.setImageResource(R.drawable.ic_location);
        actionButton.show();

        Locationn locationN =  new Locationn();

        RecycleBinLocations recycleBinLocations = new RecycleBinLocations();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id==R.id.navigate) {
            startActivity(new Intent(this, SubActivity.class));
        }
        if(id==R.id.action_button) {
            locationN.onStart();
            locationN.onStop();
            recycleBinLocations.addRecycleBin((double) R.string.latitude_label, (double) R.string.longitude_label);
            map.mapper((double) R.string.latitude_label, (double) R.string.longitude_label);
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar ){}
}
