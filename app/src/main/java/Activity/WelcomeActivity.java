package Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.onlinemaklarna.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private int[] layouts;
    private Context mContext;
    private TextView tvSignIn, tvSkip;

  //  private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = WelcomeActivity.this;

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Checking for first time launch - before calling setContentView()
    //    prefManager = new PrefManager(this);

     /*   if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }*/

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_welcome);

        viewPager = findViewById(R.id.view_pager);
        tvSkip = findViewById(R.id.tvSkip);
        tvSignIn = findViewById(R.id.tvSignIn);
        dotsLayout = findViewById(R.id.layoutDots);

        // btnSkip = (Button) findViewById(R.id.btn_skip);
        // btnNext = (Button) findViewById(R.id.btn_next);


        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[] {
                R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3
        };

        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        tvSkip.setOnClickListener(this);
        tvSignIn.setOnClickListener(this);

    }

    private void addBottomDots(int currentPage) {

        dotsLayout.removeAllViews();

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(40,40);

        for (int i = 0; i < layouts.length; i++) {

            ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(params);
            imageView.setPadding(5,5,5,5);

            if(currentPage == i) {
                imageView.setImageResource(R.drawable.ovel_yellow);
            } else {
                imageView.setImageResource(R.drawable.ovel);
            }

            dotsLayout.addView(imageView);

        }

    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        // startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
        finish();
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

    };

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSkip:
              /*  Intent intentSkip = new Intent(mContext,HomeActivity.class);
                startActivity(intentSkip);
                finish();*/
                break;

            case R.id.tvSignIn:
                Intent intentSign = new Intent(mContext,Activity_SignIn.class);
                startActivity(intentSign);
                finish();
                break;
        }

    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }

    }

}
