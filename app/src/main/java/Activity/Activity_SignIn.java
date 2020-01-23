package Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinemaklarna.R;

public class Activity_SignIn extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button btn_signin ;

    private EditText Et_mobilebankid ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_signin);


        mContext = Activity_SignIn.this;

        btn_signin = findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(this);

        Et_mobilebankid = findViewById(R.id.Et_mobilebankid);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_signin:
               Intent intentSkip = new Intent(mContext,Activity_otp.class);
                startActivity(intentSkip);
                finish();
                break;


            case R.id.Et_mobilebankid:
               /* Intent intentSkip = new Intent(mContext,HomeActivity.class);
                startActivity(intentSkip);
                finish();*/
                break;


        }

    }
}
