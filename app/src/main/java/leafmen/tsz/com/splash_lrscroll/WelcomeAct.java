package leafmen.tsz.com.splash_lrscroll;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;


/**
 * Created by LiQiang on 2015/12/18.
 */
public class WelcomeAct extends Activity {
    private static final int WAIT_TIME = 2000;
    private static final int GO_HOME = 1001;
    private static final int GO_GUIDE = 1002;
    private  boolean isFrist = false;

    private Handler mhandler = new Handler() {

        public void handleMessage(android.os.Message msg)
        {
            switch (msg.what)
            {
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            };
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        init();
    }


    private void init(){
        SharedPreferences preferences = getSharedPreferences("lzs", MODE_PRIVATE);
        isFrist = preferences.getBoolean("isFrist",true);
        if (!isFrist)
        {
            mhandler.sendEmptyMessageDelayed(GO_HOME,WAIT_TIME);
        }
        else {
            mhandler.sendEmptyMessageDelayed(GO_GUIDE,WAIT_TIME);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFrist",false);
            editor.commit();
        }
    }

    private  void goHome()
    {
        Intent intent = new Intent(WelcomeAct.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private  void goGuide()
    {
        Intent intent = new Intent(WelcomeAct.this,Guide.class);
        startActivity(intent);
        finish();
    }
}
