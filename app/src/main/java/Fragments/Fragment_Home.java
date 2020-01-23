package Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.onlinemaklarna.R;

import java.util.ArrayList;

import Activity.Activity_loadfrag;
import Adapters.Adapter_recommend;
import Adapters.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Home extends Fragment {

    private TextView seeall_recommend,seeall_properties;

    private ImageView filter ;

    ViewPager viewPager;
    private ImageView[] dots;

    LinearLayout sliderDotspanel;

    private int dotscount;

        public Fragment_Home() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_home,container,false);

            init(view);

            return view ;

        }

    private void init(View view) {


        viewPager = view.findViewById(R.id.home_viewPager);
        sliderDotspanel = view.findViewById(R.id.SliderDotshome);


        filter = view.findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               startActivity(new Intent(getActivity(), Activity_loadfrag.class).putExtra("type","searchfilter"));

            }
        });

        seeall_recommend = view.findViewById(R.id.seeall_recommend);
        seeall_recommend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

              // startActivity(new Intent(getActivity(), Activity_loadfrag.class).putExtra("type","two"));

                }
            });


        seeall_properties = view.findViewById(R.id.seeall_properties);
        seeall_properties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         //       startActivity(new Intent(getActivity(), Activity_loadfrag.class).putExtra("type","three"));

            }
        });

        //add ItemDecoration

        RecyclerView recyclerView = view.findViewById(R.id.Rv_recommend);
       // recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
       // recyclerView.setItemAnimator(new DefaultItemAnimator());

         Adapter_recommend mAdapter = new Adapter_recommend(getActivity());

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(mAdapter);


        RecyclerView rv = view.findViewById(R.id.Rv_properties);
        Adapter_recommend adapter = new Adapter_recommend(getActivity());

        LinearLayoutManager mlm = new LinearLayoutManager(getActivity());

        mlm.setOrientation(LinearLayoutManager.HORIZONTAL);

        rv.setLayoutManager(mlm);

        rv.setAdapter(adapter);

        Viewpager();

    }

    private void Viewpager() {

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];


        for(int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ovel));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ovel_yellow));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ovel));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ovel_yellow));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}
