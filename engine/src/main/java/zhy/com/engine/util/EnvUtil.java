package zhy.com.engine.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * Created by HZD on 2017/9/25.
 */

public class EnvUtil {

    private static Boolean isDebug = false;

    /**
     * 判断当前环境是否为Debug
     * @return
     */
    public static Boolean isDebug() {
        return  isDebug;
    }

    /**
     * 同步当前运行环境，在主Module中调用
     * @param context 环境变量
     */
    public static void syncIsDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            isDebug = (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            isDebug = false;
        }
    }

}
