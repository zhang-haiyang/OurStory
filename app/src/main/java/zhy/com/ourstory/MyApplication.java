package zhy.com.ourstory;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import zhy.com.engine.util.EnvUtil;

/**
 * 全局应用
 * Created by hww on 2018/1/14.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        EnvUtil.syncIsDebug(this);//初始化当前运行环境


        initNet();//初始化网络请求
        initRouter();//初始化路由
    }

    /**
     * 网络请求框架(此处的BASE_URL有严格格式规定，有了再加)
     */
    private void initNet(){
//        HttpClient.config(Constant.BASE_URL, this.getApplicationContext());
    }

    private void initRouter(){

        if (EnvUtil.isDebug()){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}