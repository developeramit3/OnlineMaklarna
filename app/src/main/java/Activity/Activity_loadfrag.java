package Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.onlinemaklarna.R;

import Fragments.Fragment_ItemDetails;
import Fragments.Fragment_filter;

public class Activity_loadfrag extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadfrag);

        if (getIntent().getExtras()!=null){

            String type=getIntent().getExtras().getString("type");

            if (type.equals("one")){
               FragTrans(new Fragment_ItemDetails());
            }
            if ((type.equals("searchfilter"))){

                FragTrans(new Fragment_filter());
            }

            /*if (type.equals("two")){
                FragTrans(new Fragment_restolist());
            }
            if (type.equals("three")){
                FragTrans(new Fragment_categories());
            }
            if (type.equals("four")){
                FragTrans(new Fragment_categories_Items());
            }
            if (type.equals("five")){
                FragTrans(new Fragment_YourCart());
            }
            if (type.equals("six")){
                FragTrans(new Fragment_address());
            }
            if (type.equals("seven")){
                FragTrans(new Fragment_filter());
            }*/

        }
    }
    public void FragTrans(Fragment fragment){

       // Fragment_restrodetails fragment2 = new Fragment_restrodetails();
        FragmentManager fragmentManager =   getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lodfram_container, fragment);
        fragmentTransaction.commit();
    }
}
