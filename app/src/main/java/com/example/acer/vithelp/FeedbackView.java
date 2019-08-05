package com.example.acer.vithelp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.acer.vithelp.Fragments.AcFragment;
import com.example.acer.vithelp.Fragments.CleaningFrag;
import com.example.acer.vithelp.Fragments.ElecFrag;
import com.example.acer.vithelp.Fragments.FoodFrag;
import com.example.acer.vithelp.Fragments.OtherFrag;
import com.example.acer.vithelp.Fragments.WaterFrag;


public class FeedbackView extends AppCompatActivity {

    String from;
    private DrawerLayout mDrawerLayout;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_layout);


        final Bundle b = getIntent().getExtras();
        from = b.getString("from");

        ft = getSupportFragmentManager().beginTransaction();
        CleaningFrag cleaningFrag = new CleaningFrag();
        cleaningFrag.setFrom(from);
        ft.replace(R.id.content_frame, cleaningFrag);
        ft.addToBackStack(null);
        ft.commit();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);




        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {
                            case R.id.ac_menu:
                                ft = getSupportFragmentManager().beginTransaction();
                                AcFragment acFragment = new AcFragment();
                                acFragment.setFrom(from);
                                ft.replace(R.id.content_frame, acFragment);
                                ft.addToBackStack(null);
                                ft.commit();


                                break;
                            case R.id.elec_menu:
                                ft = getSupportFragmentManager().beginTransaction();
                                ElecFrag elecFrag = new ElecFrag();
                                elecFrag.setFrom(from);
                                ft.replace(R.id.content_frame, elecFrag);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                            case R.id.water_menu:

                                ft = getSupportFragmentManager().beginTransaction();
                                WaterFrag waterFrag = new WaterFrag();
                                waterFrag.setFrom(from);
                                ft.replace(R.id.content_frame, waterFrag);
                                ft.addToBackStack(null);
                                ft.commit();

                                break;
                            case R.id.mess_menu:

                                ft = getSupportFragmentManager().beginTransaction();
                                FoodFrag foodFrag = new FoodFrag();
                                foodFrag.setFrom(from);
                                ft.replace(R.id.content_frame, foodFrag);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                            case R.id.others_menu:

                                ft = getSupportFragmentManager().beginTransaction();
                                OtherFrag otherFrag = new OtherFrag();
                                otherFrag.setFrom(from);
                                ft.replace(R.id.content_frame, otherFrag);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                            case R.id.clean_menu:

                                ft = getSupportFragmentManager().beginTransaction();
                                CleaningFrag cleaningFrag = new CleaningFrag();
                                cleaningFrag.setFrom(from);
                                ft.replace(R.id.content_frame, cleaningFrag);
                                ft.addToBackStack(null);
                                ft.commit();
                        }
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
