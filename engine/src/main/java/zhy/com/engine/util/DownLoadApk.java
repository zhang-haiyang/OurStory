package zhy.com.engine.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import zhy.com.engine.R;

/**
 * 更新新版本APK
 * Created by hww on 2018/1/24.
 */

public class DownLoadApk {

    private Context mContext;
    private String apkUrl;

    public DownLoadApk(Context context, String url){
        this.mContext = context;
        this.apkUrl = url;
    }

    //此保存位置一定要事先在用户手机上开辟
    private static final String savePath = "/sdcard/zhy/download/";//安装包下载路径,(流下载方式必须在前面以sdcard开头)
    private static final String saveFileName = savePath + "身边事.apk";//安装包文件名

    private static final int DOWN_UPDATE = 1;//下载中
    private static final int DOWN_OVER = 2;//下载完成

    private Thread downLoadThread;
    private boolean interceptFlag = false;//拦截旗帜，默认不拦截
    private Dialog downLoadingDialog;
    private int progress;
    private TextView mPercentageTV, mCancelTV;

    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what){
                case DOWN_UPDATE:
                    mPercentageTV.setText("正在下载：" + progress + "%");
                    break;
                case DOWN_OVER:
                    downLoadingDialog.dismiss();
                    //安装（完成后自动删除）
                    AppUtils.installApp(saveFileName, "zhy.com.disabuse.provider");
                    break;
                default:
                    break;
            }
        }
    };

    //使用流下载APK的过程
    private Runnable downApkRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(apkUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                int length = connection.getContentLength();
                InputStream inputStream = connection.getInputStream();
                //安装包文件目录
                File file = new File(savePath);
                if (!file.exists()) {
                    file.mkdir();
                }
                //安装包文件名
                String apkFile = saveFileName;
                File AokFile = new File(apkFile);
                FileOutputStream fileOutputStream = new FileOutputStream(AokFile);

                int count = 0;
                byte buff [] = new byte[1024];
                do{
                    //输入流将数据读到缓冲区
                    int numread = inputStream.read(buff);
                    count += numread;//拼起来
                    progress = (int) (((float)count / length) * 100);
                    //通知更新
                    mHandler.sendEmptyMessage(DOWN_UPDATE);
                    if (numread <= 0) {
                        //通知安装
                        mHandler.sendEmptyMessage(DOWN_OVER);
                        break;
                    }
                    //输出流从缓冲区写出来,从头写，写numread这么多
                    fileOutputStream.write(buff, 0, numread);
                }while (!interceptFlag);//点击取消变成拦截，则本行false，跳出循环
                fileOutputStream.close();
                inputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * 下载APK
     */
    public void downloadApk(){
        showDownloadDialog();

        downLoadThread = new Thread(downApkRunnable);
        downLoadThread.start();
    }

    /**
     * 进度提醒
     */
    private void showDownloadDialog(){
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.update_apk_progress, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        mPercentageTV =  view.findViewById(R.id.tv_percentage);
        mCancelTV =  view.findViewById(R.id.id_cancel);
        builder.setView(view);
        mCancelTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadingDialog.dismiss();
                interceptFlag = true;
            }
        });

        downLoadingDialog = builder.create();
        downLoadingDialog.setCancelable(false);
        downLoadingDialog.show();
    }

}
