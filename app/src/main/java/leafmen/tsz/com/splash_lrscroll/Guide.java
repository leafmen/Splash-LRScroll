package leafmen.tsz.com.splash_lrscroll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
//import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiQiang on 2015/12/18.
 */
public class Guide extends Activity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<View> views;
    private ImageView[] dots;
    private int[] ids = {R.id.iv1,R.id.iv2,R.id.iv3};
//    private Button btnStart;
    private TextView tvInNew;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        initViews();
        initDots();

    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.guideone,null));
        views.add(inflater.inflate(R.layout.guidetwo,null));
        views.add(inflater.inflate(R.layout.guidethree,null));

        viewPagerAdapter = new ViewPagerAdapter(views,this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(this);

        tvInNew = (TextView) views.get(2).findViewById(R.id.tvInNew);
        tvInNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guide.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        btnStart = (Button) views.get(2).findViewById(R.id.btnStart);
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Guide.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//
//            }
//        });


    }

    private  void initDots() {
        dots = new ImageView[views.size()];
        for(int i=0;i<views.size();i++)
        {
            dots[i] = (ImageView)findViewById(ids[i]);
        }

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int arg0) {
        for (int i=0;i<ids.length;i++)
        {
            if (arg0 == i)
            {
                dots[i].setImageResource(R.drawable.umeng_socialize_follow_on);
            }
            else
            {
                dots[i].setImageResource(R.drawable.umeng_socialize_follow_off);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
