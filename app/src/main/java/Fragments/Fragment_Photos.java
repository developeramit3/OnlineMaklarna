package Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinemaklarna.R;

import Adapters.Adapter_photos;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Photos extends Fragment {


    public Fragment_Photos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photos,container,false);

        init(view);

        return view ;

    }

    private void init(View view) {

        RecyclerView rv = view.findViewById(R.id.rv_photos);

        Adapter_photos adapter = new Adapter_photos(getActivity());

        rv.setLayoutManager(new GridLayoutManager(getActivity() , 2));

        rv.setAdapter(adapter);

    }

}
