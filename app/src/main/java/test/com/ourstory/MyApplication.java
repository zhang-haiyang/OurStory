package test.com.ourstory;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;

import test.com.engine.util.EnvUtil;
import test.com.ourstory.util.LifeCycleUtil;

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

        registerLifeCycle();//注册生命周期回调

        Utils.init(this);//初始化工具集

    }

    /**
     * 网络请求框架(此处的BASE_URL有严格格式规定，有了再加)
     */
    private void initNet(){
//        HttpClient.config(Constant.BASE_URL, this.getApplicationContext());
    }

    /**
     * 配置路由
     */
    private void initRouter(){
        if (EnvUtil.isDebug()){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }

    /**
     * 注册生命周期回调
     */
    private void registerLifeCycle(){
        new LifeCycleUtil().registerLife(this);
    }


}
