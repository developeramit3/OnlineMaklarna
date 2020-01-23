package SELLER_SIDE.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlinemaklarna.R;

import Adapters.Adapter_msg;
import SELLER_SIDE.Adapter.Adapter_myproperties;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_property extends Fragment {


    public Fragment_property() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_property,container,false);

        init(view);

        return view ;
    }

    private void init(View view) {

        RecyclerView rv = view.findViewById(R.id.rv_seller_properties);

        Adapter_myproperties adapter = new Adapter_myproperties(getActivity());

        LinearLayoutManager mlm = new LinearLayoutManager(getActivity());

        mlm.setOrientation(LinearLayoutManager.VERTICAL);

        rv.setLayoutManager(mlm);

        rv.setAdapter(adapter);


    }

}
