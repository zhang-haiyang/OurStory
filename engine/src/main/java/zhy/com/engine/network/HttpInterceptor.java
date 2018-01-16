package zhy.com.engine.network;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import zhy.com.engine.util.EnvUtil;

/**
 * 网络请求拦截器
 */

public class HttpInterceptor implements Interceptor {

    private Context mContext;

    HttpInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final android.os.Handler handler = new Handler(mContext.getMainLooper());

        Request request = chain.request();

        String requestUrl = request.url().toString();
        String requestBodyString = "";
        FormBody requestBody = (FormBody) request.body();

        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            Charset charset = Charset.forName("UTF-8");
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            requestBodyString = buffer.clone().readString(charset);
        }

//        String host = HttpClient.sBaseUrl.substring(0, HttpClient.sBaseUrl.length() - 3);
//        String action = requestUrl.substring(host.length());
        Request.Builder builder = request.newBuilder();
//        builder.addHeader("sign", Signature.create(action));

        Request newRequest = builder.build();

        final Response response = chain.proceed(newRequest);


        String responseBodyString;
        ResponseBody body = response.body();
        if (response.code() != 200) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (EnvUtil.isDebug()) {
                        Toast.makeText(mContext, response.message(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, response.message(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
            return response;
        }

        // 获取整个Body对象
        BufferedSource source = body.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        Charset charset = Charset.defaultCharset();
        MediaType contentType = body.contentType();
        if (contentType != null) {
            charset = contentType.charset(charset);
        }
        responseBodyString = buffer.clone().readString(charset);

        try {
            final JSONObject bodyObject = new JSONObject(responseBodyString);
            int status = bodyObject.getInt("status");

            final String message = bodyObject.getString("message");


            // 在网络请求失败的时候，弹出提示
            if (status != HttpResponseStatus.SUCCESS) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (EnvUtil.isDebug()) {
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }

            Intent intent = new Intent();
            // 处理Token过期的问题
            if (status == HttpResponseStatus.TOKEN_EXPIRED) {
                intent.setAction(HttpResponseStatus.NEED_LOGIN_ACTION);
                mContext.sendBroadcast(intent);
            } else if (status == HttpResponseStatus.SIGN_TIME_EXPIRED) {
                intent.setAction(HttpResponseStatus.NEED_UPDATE_SIGN_TIME);
                mContext.sendBroadcast(intent);
            }
            response.code();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // 如果为开发环境，则打印日志
        if (EnvUtil.isDebug()) {
            Logger.d(requestUrl);
            Logger.d(requestBodyString);
            Logger.d(responseBodyString);
        }

        return response;
    }

}
