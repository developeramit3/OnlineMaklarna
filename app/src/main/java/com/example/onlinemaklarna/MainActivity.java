package com.example.onlinemaklarna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Fragments.Fragment_Home;
import Fragments.Fragment_Inbox;
import Fragments.Fragment_notify;
import Fragments.Fragment_search;
import Fragments.Fragment_setting;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        //loading the default fragment
        loadFragment(new Fragment_Home());
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {

            clearStack();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                    .addToBackStack(null)
                    .commit();

            return true;

        }


        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new Fragment_Home();
                break;

            case R.id.navigation_search:
                fragment = new Fragment_search();
                break;

            case R.id.navigation_inbox:
                fragment = new Fragment_Inbox();
                break;

            case R.id.navigation_notification:
                fragment = new Fragment_notify();
                break;

            case R.id.navigation_settings:
                  fragment = new Fragment_setting();
                break;
        }

        return loadFragment(fragment);
    }


    public void clearStack() {

        //https://readyandroid.wordpress.com/remove-fragment-with-clear-back-stack/

        //Here we are clearing back stack fragment entries
        int backStackEntry = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntry > 0) {
            for (int i = 0; i < backStackEntry; i++) {
                getSupportFragmentManager().popBackStackImmediate();
                //  homeFragment();
            }
        }

        //Here we are removing all the fragment that are shown here
        if (getSupportFragmentManager().getFragments() != null && getSupportFragmentManager().getFragments().size() > 0) {
            for (int i = 0; i < getSupportFragmentManager().getFragments().size(); i++) {
                Fragment mFragment = getSupportFragmentManager().getFragments().get(i);
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().remove(mFragment).commit();
                    //   homeFragment();
                }
            }
        }
    }
}
