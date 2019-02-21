package com.zeidat.finalcar.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.zeidat.finalcar.R ;
import com.zeidat.finalcar.dagger.AppModule;
import com.zeidat.finalcar.dagger.DaggerLamdComponent;
import com.zeidat.finalcar.dagger.FragmentsModule;
import com.zeidat.finalcar.dagger.LamdComponent;
import com.zeidat.finalcar.fragments.*;


import javax.inject.Inject;

public class GetLamd extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    Calender calender ;
    @Inject
    StudentsFragment studentsFragment ;
    @Inject
    HomeFragment homeFragment ;
    @Inject
    AddAppointment addAppointment ;
    @Inject
    VehicleFragment vehicleFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_lamd);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getLamdComponent(getApplicationContext()).inject(this);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction() ;
        transaction.add(R.id.fragmentContainer ,homeFragment).commit() ;


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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeFragment/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = homeFragment ;

        if (id == R.id.nav_calender) { fragment = calender ; }

        else if (id == R.id.nav_student) { fragment = studentsFragment ; }

        else if (id == R.id.nav_home) {  fragment = homeFragment ; }

        else if (id == R.id.nav_car) { fragment = vehicleFragment ; }

        else if (id == R.id.nav_appointment) {  fragment = addAppointment ; }

        //else if (id == R.id.nav_share) {}

        else if (id == R.id.nav_send) {}


        /**
         * replace fragments on slide menu's options click
         */
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction() ;
        transaction.replace(R.id.fragmentContainer,fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public LamdComponent getLamdComponent(Context context){
        return DaggerLamdComponent.builder()
                .fragmentsModule(new FragmentsModule())
                .appModule(new AppModule(context))
                .build() ;
    }
}
