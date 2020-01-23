package Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.onlinemaklarna.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_filter extends Fragment {

    private Button btn_applyfilter ;


    public Fragment_filter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_filter,container,false);

        init(view);

        return view ;
    }

    private void init(View view) {

        btn_applyfilter =  view.findViewById(R.id.btn_applyfilter);

     btn_applyfilter.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             getActivity().getSupportFragmentManager().popBackStack();
         }
     });

    }

}
