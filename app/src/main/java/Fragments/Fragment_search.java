package Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinemaklarna.R;

import Adapters.Adapter_photos;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_search extends Fragment {


    public Fragment_search() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_search,container,false);

        init(view);

        return view ;

    }

    private void init(View view) {


    }

}
