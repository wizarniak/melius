package qz.seventeen.melius;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText item;
    TextView itemName;
    TextView itemProtein;
    TextView itemCarbs;
    TextView itemFat;
    TextView itemCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        item = (EditText) findViewById(R.id.toeat);
        itemName = (TextView) findViewById(R.id.item_name);
        itemProtein = (TextView) findViewById(R.id.protein);
        itemCarbs = (TextView) findViewById(R.id.carbs);
        itemFat = (TextView) findViewById(R.id.fat);
        itemCalories = (TextView) findViewById(R.id.calories);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            startActivityForResult(new Intent(MainActivity.this, DetailsActivity.class), 0);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.find_restaurants) {
            Intent i = new Intent(MainActivity.this, FindRestaurantsActivity.class);
            MainActivity.this.startActivity(i);
        }
        if (id == R.id.find_recipes) {
            Intent i = new Intent(MainActivity.this, FindRecipesActivity.class);
            MainActivity.this.startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getInfo(View v) {
        String itemNameString = item.getText().toString();
        if (itemNameString.toLowerCase() == "mcchicken") {
            itemName.setText(itemNameString);
            itemProtein.setText("Protein: 15g");
            itemCarbs.setText("Carbs: 41g");
            itemFat.setText("Fat: 16g");
            itemCalories.setText("Calories: 370");
        } else if (itemNameString.toLowerCase() == "shawarma") {
            itemName.setText(itemNameString);
            itemProtein.setText("Protein: 39g");
            itemCarbs.setText("Carbs: 45g");
            itemFat.setText("Fat: 9g");
            itemCalories.setText("Calories: 430");
        }
    }

}
