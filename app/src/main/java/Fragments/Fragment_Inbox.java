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

import Adapters.Adapter_msg;
import Adapters.Adapter_photos;
import Adapters.Adapter_recommend;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Inbox extends Fragment {


    public Fragment_Inbox() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__inbox,container,false);

        init(view);

        return view ;


    }

    private void init(View view) {

        RecyclerView rv = view.findViewById(R.id.Rv_msg);

        Adapter_msg adapter = new Adapter_msg(getActivity());

        LinearLayoutManager mlm = new LinearLayoutManager(getActivity());

        mlm.setOrientation(LinearLayoutManager.VERTICAL);

        rv.setLayoutManager(mlm);

        rv.setAdapter(adapter);

    }

}
