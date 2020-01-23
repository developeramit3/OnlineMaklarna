package Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinemaklarna.R;

import SELLER_SIDE.Activity_sellerHome;

public class Activity_getstarted extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button btn_guest,btn_buyer ,btn_seller ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_getstarted);


        mContext = Activity_getstarted.this;

        btn_guest = findViewById(R.id.btn_guest);
        btn_guest.setOnClickListener(this);

        btn_buyer = findViewById(R.id.btn_buyer);
        btn_buyer.setOnClickListener(this);

        btn_seller = findViewById(R.id.btn_seller);
        btn_seller.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_guest:
               /* Intent intentSkip = new Intent(mContext,HomeActivity.class);
                startActivity(intentSkip);
                finish();*/
                break;


            case R.id.btn_buyer:
                Intent intentSkip = new Intent(mContext,WelcomeActivity.class);
                startActivity(intentSkip);
                finish();
                break;


            case R.id.btn_seller:
                Intent iintent = new Intent(mContext, Activity_sellerHome.class);
                startActivity(iintent);
                finish();
                break;



        }

    }
}
