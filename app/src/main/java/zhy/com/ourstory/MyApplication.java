package zhy.com.ourstory;

import android.app.Application;
import android.content.Context;

import zhy.com.engine.network.HttpClient;
import zhy.com.ourstory.config.Constant;

/**
 * 全局应用
 * Created by hww on 2018/1/14.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        initNet();
    }

    /**
     * 网络请求框架(此处的BASE_URL有严格格式规定，有了再加)
     */
    private void initNet(){
//        HttpClient.config(Constant.BASE_URL, this.getApplicationContext());
    }
}
