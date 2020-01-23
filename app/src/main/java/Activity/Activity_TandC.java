package Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinemaklarna.MainActivity;
import com.example.onlinemaklarna.R;

public class Activity_TandC extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button btn_continue ;

    private CheckBox check  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_terms_and_condition);

        mContext = Activity_TandC.this;

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(this);

        check = findViewById(R.id.check);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_continue:
                Intent intentSkip = new Intent(mContext, MainActivity.class);
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
