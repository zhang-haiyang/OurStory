package test.com.ourstory.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.Logger;

import test.com.engine.R;

/**
 * 所有页面的生命周期方法
 * Created by hww on 2018/1/16.
 */

public class LifeCycleUtil {
    ImmersionBar mImmersionBar = null;

    private Application.ActivityLifecycleCallbacks lifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            //状态栏背景不透明，文字黑色
            mImmersionBar =  ImmersionBar.with(activity).statusBarColor(R.color.white).statusBarDarkFont(true);
            mImmersionBar.init();
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            if (mImmersionBar != null){
                try {
                    mImmersionBar.destroy();
                }catch (Exception e){
                    Logger.d(e);
                }
            }
        }
    };

    public void registerLife(Application application){
        application.registerActivityLifecycleCallbacks(lifecycleCallbacks);
    }
}
