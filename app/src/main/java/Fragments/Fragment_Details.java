package Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;


import com.example.onlinemaklarna.R;
import com.google.android.material.tabs.TabLayout;

public class Fragment_Details extends Fragment {

    private Button btn_bid ;

    public Fragment_Details() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details,container,false);

        init(view);

        return view ;

    }

    private void init(View view) {

        btn_bid = view.findViewById(R.id.btn_bid);
        btn_bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opendialog();

            }
        });

    }

    private void opendialog() {

        Button btn_submitbid ;

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_bid);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        btn_submitbid = dialog.findViewById(R.id.btn_submitbid);
        btn_submitbid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               dialog.dismiss();

            }
        });

        dialog.setCancelable(false);
        dialog.show();

    }


}

