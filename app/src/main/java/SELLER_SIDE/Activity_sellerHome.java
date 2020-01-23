package SELLER_SIDE;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.onlinemaklarna.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import Fragments.Fragment_Home;
import Fragments.Fragment_Inbox;
import Fragments.Fragment_notify;
import Fragments.Fragment_search;
import Fragments.Fragment_setting;
import SELLER_SIDE.Fragments.Fragment_property;

public class Activity_sellerHome extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller_home);


        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.sellernavigation);
        navigation.setOnNavigationItemSelectedListener(this);

        //loading the default fragment
        loadFragment(new Fragment_property());
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {

            clearStack();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.sellerfragmentContainer, fragment)
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
            case R.id.S_navigation_home:
                fragment = new Fragment_property();
                break;

            case R.id.S_navigation_inbox:
                fragment = new Fragment_Inbox();
                break;

            case R.id.S_navigation_notification:
                fragment = new Fragment_notify();
                break;

            case R.id.S_navigation_settings:
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
