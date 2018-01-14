package zhy.com.engine.network;

/**
 * 网络请求返回状态（属性要和后台约定）
 * Created by hww on 2018/1/14.
 */

public interface HttpResponseStatus {

    //处理TOKEN过期的问题
    String NEED_LOGIN_ACTION = "needLogin";
    String NEED_UPDATE_SIGN_TIME = "needUpdateSignTime";

    int SUCCESS = 2000;

    int TOKEN_EXPIRED = 2001;

    int SIGN_TIME_EXPIRED = 4001;

}
