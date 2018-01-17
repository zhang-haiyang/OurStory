package zhy.com.video.activity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import zhy.com.video.R;
import zhy.com.video.customView.VideoPlayerLayout;
import zhy.com.video.listener.VideoPlayerListener;

/**
 * 视屏播放页
 * Created by hww on 2018/1/17.
 */

public class OpenVideoActivity extends AppCompatActivity {

    private VideoPlayerLayout mVideoPlayerLayout;
    private String mVideoUrl = "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=63180&editionType=normal&source=aliyun";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_video);
        initView();
        initData();
    }

    private void initView(){
        mVideoPlayerLayout = findViewById(R.id.vpl_open_video);
    }

    private void initData(){

        VideoPlayerListener videoPlayerListener = new VideoPlayerListener(){
            @Override
            public void onPrepared(String url, Object... objects) {
                Debuger.printfError("***** onPrepared **** " + objects[0]);
                Debuger.printfError("***** onPrepared **** " + objects[1]);
                super.onPrepared(url, objects);
                //开始播放了才能旋转和全屏
            }

            @Override
            public void onEnterFullscreen(String url, Object... objects) {
                super.onEnterFullscreen(url, objects);
            }

            @Override
            public void onAutoComplete(String url, Object... objects) {
                super.onAutoComplete(url, objects);
            }

            @Override
            public void onClickStartError(String url, Object... objects) {
                super.onClickStartError(url, objects);
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);

                finish();
            }

            @Override
            public void onClickBlank(String url, Object... objects) {
                super.onClickBlank(url, objects);
                hideVirtualKey();
            }
        };

        GSYVideoOptionBuilder gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
        gsyVideoOptionBuilder
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setShowFullAnimation(false)
                .setNeedLockFull(false)
                .setSeekRatio(2)
                .setUrl(mVideoUrl)
                .setNeedShowWifiTip(true)
                .setCacheWithPlay(true)
                .setVideoTitle("视频测试")
                .setStandardVideoAllCallBack(videoPlayerListener)
                .build(mVideoPlayerLayout);

        mVideoPlayerLayout.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mVideoPlayerLayout.startWindowFullscreen(OpenVideoActivity.this, true, true);
        mVideoPlayerLayout.startPlayLogic();

    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideVirtualKey() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    @Override
    protected void onPause() {
        getPlayer().onVideoPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        getPlayer().onVideoResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPlayer().release();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    private GSYVideoPlayer getPlayer(){
        if (mVideoPlayerLayout.getFullWindowPlayer() != null){
            return mVideoPlayerLayout.getFullWindowPlayer();
        }
        return mVideoPlayerLayout;
    }
}
