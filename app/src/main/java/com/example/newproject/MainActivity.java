package com.example.newproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.newproject.dummy.CategoryList;
import com.example.newproject.dummy.JobList;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements JobsFragment.OnListFragmentInteractionListener,CategoryFragment.OnListFragmentInteractionListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        CategoryFragment fragment = new CategoryFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.jobs_frame,
                fragment,"Email_fragment_tag").commit();
        navigationView = findViewById(R.id.navigation_menu);
        this.setTitle("Category");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        CategoryFragment cat = new CategoryFragment();
                        fragmentChange(cat);
                        break;
                    case R.id.Account:
                        Profile fragment1 = new Profile();
                        fragmentChange(fragment1);
                        break;
                    case R.id.given_jobs:
                        JobsFragment fragment = new JobsFragment();
                        fragmentChange(fragment);
                        break;
                    case R.id.logout:
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }


    private void fragmentChange(Fragment fr){
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.jobs_frame,fr).commit();
        MainActivity.this.setTitle("Jobs");
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        this.getSupportFragmentManager().popBackStack();
    }

    private void setUpToolbar(){
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onListFragmentInteraction(JobList.Jobs item) {
        Details fragment = new Details(item.profileName);
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.jobs_frame,fragment).commit();

    }

    @Override
    public void onListFragmentInteraction(CategoryList.Category item) {
        JobsFragment jb = new JobsFragment(item.categoryName);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.jobs_frame,jb).commit();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
