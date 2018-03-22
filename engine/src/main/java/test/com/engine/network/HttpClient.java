package test.com.engine.network;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求管理类
 * Created by hww on 2018/1/14.
 */

public class HttpClient {
    private static Retrofit sRetrofit;

    /**
     * 网络请求基地址
     */
    private static String sBaseUrl = "";

//    private static Context sContext;

    /**
     * 请求连接超时时间
     */
    public static final int CONNECT_TIME_OUT = 10 * 1000;

    /**
     * 读取超时时间
     */
    public static final int READ_TIME_OUT = 10 * 1000;

    /**
     * 配置网络请求
     * @param url
     * @param context
     */
    public static void config(String url, Context context){
        sBaseUrl = url;
//        sContext = context;

        if (sRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //超时管理
            builder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS).readTimeout(READ_TIME_OUT, TimeUnit.SECONDS).build();
            //添加拦截器，处理日志及请求后的处理
            builder.addInterceptor(new HttpInterceptor(context));

            OkHttpClient client = builder.build();
            sRetrofit = new Retrofit.Builder().baseUrl(sBaseUrl).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
    }

    /**
     * 创建网络请求对象
     * @param className
     * @param <T>
     * @return
     */
    public static <T> T create(Class<T> className){
        return sRetrofit.create(className);
    }
}
