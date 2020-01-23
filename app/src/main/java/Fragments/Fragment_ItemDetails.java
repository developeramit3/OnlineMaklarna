package Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.onlinemaklarna.R;
import com.google.android.material.tabs.TabLayout;

public class Fragment_ItemDetails extends Fragment {

    private FrameLayout simpleFrameLayout;
    private TabLayout tabLayout;


    public Fragment_ItemDetails() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_itemdetails,container,false);

        init(view);

        return view ;

    }

    private void init(View view) {

// get the reference of FrameLayout and TabLayout
        simpleFrameLayout = (FrameLayout) view.findViewById(R.id.simpleFrameLayout);
        tabLayout = (TabLayout) view.findViewById(R.id.simpleTabLayout);
// Create a new Tab named "First"
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("DETAILS"); // set the Text for the first Tab
        //     firstTab.setIcon(R.drawable.ic_launcher); // set an icon for the
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout

// Create a new Tab named "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("PHOTOS (10)"); // set the Text for the second Tab
        //  secondTab.setIcon(R.drawable.ic_launcher); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout

// perform setOnTabSelectedListener event on TabLayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
// get the current selected tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new Fragment_Details();
                        break;
                    case 1:
                       fragment = new Fragment_Photos();
                        break;
                }

                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                        .addToBackStack(null)
                        .commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        }
    }

