package test.com.disabuse.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import test.com.disabuse.R;
import test.com.engine.util.DownLoadApk;

/**
 * 首页解忧碎片
 * Created by hww on 2018/1/16.
 */

public class DisabuseFragment extends Fragment {

    private View mViewV;
    private TextView mUpDateTV, mTimeDownTV;
    private DownLoadApk downLoadApk;
    private int time = 10;

    //handler在声明的时候，在handleMessage方法中进行ui的操作
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    int value = msg.arg1;
                    mTimeDownTV.setText(value + "秒");
                    mTimeDownTV.setClickable(false);
                    break;
                case 2:
                    mTimeDownTV.setText("请再次点击");
                    mTimeDownTV.setClickable(true);
                    break;
                    default:
                        break;
            }
        }
    };


    private int maxCount = 20;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private int delayTime = 1000;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (maxCount == 0){
                mTimeDownTV.setClickable(true);
                mTimeDownTV.setText("请再次点击");
            }else {
                maxCount--;
                mTimeDownTV.setText(maxCount + "秒");
                mTimeDownTV.setClickable(false);
            }
            mHandler.postDelayed(mRunnable, delayTime);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_disabuse, container, false);
        initView();
        initData();
        return mViewV;
    }

    private void initView(){
        mUpDateTV = mViewV.findViewById(R.id.tv_update);
        mTimeDownTV = mViewV.findViewById(R.id.tv_timedown);
        downLoadApk = new DownLoadApk(getActivity(), "http://file.yirimao.com/2.2.4/app-shuihe.apk");//测试地址
//        downLoadApk = new DownLoadApk(getActivity(), "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=442708598,4076261259&fm=55&s=E3BC2F66D4C178F0193B176F0300F06C&w=121&h=81&img.JPEG");//测试地址

    }

    private void initData(){
        mUpDateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                downLoadApk.downloadApk();
                Toast.makeText(getActivity(), "安装包更新测试，请勿点击", Toast.LENGTH_SHORT).show();
            }
        });
        mTimeDownTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TimeDown();
//                handlerTimeDown();
                mHandler.postDelayed(mRunnable, delayTime);
            }
        });
    }

    private void TimeDown(){
        mTimeDownTV.setClickable(false);
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int theTime = time--;
                        String timeDown = Integer.toString(theTime);
                        mTimeDownTV.setText(timeDown + "秒");
                        if (time < 0) {
                            timer.cancel();
                            mTimeDownTV.setClickable(true);
                            mTimeDownTV.setText("请再次点击");
                        }
                    }
                });
            }
        };
        time = 10;
        timer.schedule(timerTask,0,1000);
    }

    //在子线程中进行数据的变化
    private void handlerTimeDown(){
        new Thread(){
            @Override
            public void run() {
                int time = 15;
                while (time > 0){
                    time--;
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Message msg = Message.obtain();
                    msg.what = 1;
                    msg.arg1 = time;
                    if (time == 0){
                        msg.what = 2;
                    }
                    handler.sendMessage(msg);
                }
            }
        }.start();
    }

}
