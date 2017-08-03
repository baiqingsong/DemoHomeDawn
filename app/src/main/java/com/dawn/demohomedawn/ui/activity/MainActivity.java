package com.dawn.demohomedawn.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.dawn.demohomedawn.R;

public class MainActivity extends Activity {
    private TextView mCountDownTextView;
    private Handler mHandler = new Handler();
    private CustomCountDownTimer mCountDownTimer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mCountDownTextView = (TextView) findViewById(R.id.start_skip_count_down);
        mCountDownTextView.setText("3s 跳过");
        //创建倒计时
        //创建倒计时类
        mCountDownTimer = new CustomCountDownTimer(3000, 1000);
        mCountDownTimer.start();
        //3秒后跳转或者点击跳转到主界面
        mHandler.postDelayed(runnable, 3000);
        mCountDownTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToMain();
                mHandler.removeCallbacks(runnable);
            }
        });
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            jumpToMain();
        }
    };

    /**
     * 跳转到主界面
     */
    private void jumpToMain(){
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
    class CustomCountDownTimer extends CountDownTimer {
        /**
         * @param millisInFuture
         *      表示以「 毫秒 」为单位倒计时的总数
         *      例如 millisInFuture = 1000 表示1秒
         *
         * @param countDownInterval
         *      表示 间隔 多少微秒 调用一次 onTick()
         *      例如: countDownInterval = 1000 ; 表示每 1000 毫秒调用一次 onTick()
         *
         */

        public CustomCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }


        public void onFinish() {
            mCountDownTextView.setText("0s 跳过");
        }

        public void onTick(long millisUntilFinished) {
            mCountDownTextView.setText( millisUntilFinished / 1000 + "s 跳过");
        }

    }
    @Override
    protected void onDestroy() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        super.onDestroy();
    }
}
