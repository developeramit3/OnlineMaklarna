package Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinemaklarna.R;

public class Activity_otp extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button btn_submitotp ;

    private TextView tv_resendcode  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_otp);

        mContext = Activity_otp.this;

        btn_submitotp = findViewById(R.id.btn_submitotp);
        btn_submitotp.setOnClickListener(this);

        tv_resendcode = findViewById(R.id.tv_resendcode);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_submitotp:
                Intent intentSkip = new Intent(mContext,Activity_TandC.class);
                startActivity(intentSkip);
                finish();
                break;


            case R.id.tv_resendcode:
               /* Intent intentSkip = new Intent(mContext,HomeActivity.class);
                startActivity(intentSkip);
                finish();*/
                break;


        }

    }
}
