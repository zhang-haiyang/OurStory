package test.com.ourstory.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.AppUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import test.com.disabuse.fragment.DisabuseFragment;
import test.com.engine.customView.MainTabItemView;
import test.com.engine.customView.NoScrollViewPage;
import test.com.ourstory.R;
import test.com.ourstory.adapter.MainViewPagerAdapter;
import test.com.speech.fragment.SpeechFragment;
import test.com.story.fragment.StoryFragment;
import test.com.video.fragment.VideoFragment;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private NoScrollViewPage mViewPagerVP;
    private MainViewPagerAdapter mAdapter;

    //四个模块碎片
    private StoryFragment mStoryFragment;
    private SpeechFragment mSpeechFragment;
    private DisabuseFragment mDisabuseFragment;
    private VideoFragment mVideoFragment;

    //当前版本号
    private int mCurrentVersionCode;

    //小米渠道的推送字段
    private String APPID = "2882303761517730005";
    private String APPKEY = "5301773086005";

    //魅族渠道的推送字段
    private String MZAPPID = "112490";
    private String MZAPPKEY = "8282363b707d4fe08f33a15e127920d2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutXGPush();
        initView();
        initData();
    }



    //关于信鸽推送
    private void aboutXGPush(){
        //注意：XGPushConfig类下的set/enable方法，应该在XGPushManager类之前调用才能生效
        //调试时使用,正式使用时参数设置为fals
        XGPushConfig.enableDebug(this, true);


        //小米渠道的推送（尽量确保程序被杀时，在小米手机上仍能收到推送）
        XGPushConfig.setMiPushAppId(getApplicationContext(), APPID);
        XGPushConfig.setMiPushAppKey(getApplicationContext(), APPKEY);
        //打开第三方推送
        XGPushConfig.enableOtherPush(getApplicationContext(), true);

        //魅族渠道的推送
        XGPushConfig.setMzPushAppId(this, MZAPPID);
        XGPushConfig.setMzPushAppKey(this, MZAPPKEY);

        XGPushConfig.setHuaweiDebug(true);


        //对于有账号的APP应该使用账号注册，则参数中的account字段应该使用别名，并提供带有回调的参数
        XGPushManager.bindAccount(MainActivity.this,  "账号", new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                //token在设备卸载重装的时候有可能会变
                Log.i("TPush", "注册成功，设备token为：" + data);

                //在注册成功时，获取设备的token
                XGPushConfig.getToken(MainActivity.this);
                //经过测试是没问题的
            }
            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.i("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });

    }

    private void initView(){
        configViewPager();
        initTabBar();//注意与上方代码的先后顺序
    }

    private void initData(){
        getCurrentVersionCode();
    }

    /**
     * 设置VP及其适配器
     */
    private void configViewPager(){
        mViewPagerVP = findViewById(R.id.vp_main);
        mViewPagerVP.setNoScroll(true);

        List<Fragment> fList = new ArrayList<>();
        mStoryFragment = new StoryFragment();
        mSpeechFragment = new SpeechFragment();
        mDisabuseFragment = new DisabuseFragment();
        mVideoFragment = new VideoFragment();
        fList.add(mStoryFragment);
        fList.add(mSpeechFragment);
        fList.add(mDisabuseFragment);
        fList.add(mVideoFragment);

        FragmentManager fragmentManager = getSupportFragmentManager();

        mAdapter = new MainViewPagerAdapter(fragmentManager, fList);
        mViewPagerVP.setAdapter(mAdapter);
        mViewPagerVP.setCurrentItem(0);
        mViewPagerVP.setOffscreenPageLimit(1);
    }

    /**
     * 初始化底部导航栏
     */
    private void initTabBar(){
        PageNavigationView tabBar = findViewById(R.id.tab_bar);
        NavigationController navigationController = tabBar.custom()
                .addItem(initTabBarItem(R.drawable.story_normal, R.drawable.story_selected, "故事"))
                .addItem(initTabBarItem(R.drawable.speech_normal, R.drawable.speech_selected, "言论"))
                .addItem(initTabBarItem(R.drawable.disabuse_normal, R.drawable.disabuse_selected, "解忧"))
                .addItem(initTabBarItem(R.drawable.video_normal, R.drawable.video_selected, "视频"))
                .build();
        navigationController.setupWithViewPager(mViewPagerVP);
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                if (index == 0){

                }else if (index == 1){
//                    PictureSelector.create(MainActivity.this)
//                            .openGallery(PictureMimeType.ofAll()).isGif(true).isCamera(false).previewImage(false).previewVideo(false).maxSelectNum(9)
//                            .minSelectNum(1).forResult(PictureConfig.CHOOSE_REQUEST);
                }else if (index == 2){

                }else if (index == 3){

                }
            }

            @Override
            public void onRepeat(int index) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Log.i("视频路径：原视频", "进入");
            Toast.makeText(MainActivity.this, "sdsd", Toast.LENGTH_SHORT).show();
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    String videoPath = selectList.get(0).getPath();
                    Log.i("视频路径：原视频", videoPath);

                    String smallVideoPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/yirimao/downloasd";
                    CompressUtil.doCompress(this, videoPath, smallVideoPath);
//                    try {
//                        String filePath = SiliCompressor.with(this).compressVideo(videoPath, smallVideoPath);
                        Log.i("视频路径：压缩视频路径", smallVideoPath);
                        File file = new File(smallVideoPath);
                        File file1 = new File(videoPath);
                        double numLength = (double)(file.length()) / (1024 * 1024);
                        double numLength1 = (double)(file1.length()) / (1024 * 1024);
                        Log.i("视频路径：压缩视频大小", numLength + "");
                        Log.i("视频路径：原视频大小", numLength1 + "");
//                    } catch (URISyntaxException e) {
//                        e.printStackTrace();
//                    }
                    break;
            }
        }
    }


    /**
     * 初始化tabBar的图文及其颜色
     */
    private BaseTabItem initTabBarItem(int normalDrawable, int selectedDrawable, String text){
        MainTabItemView itemView = new MainTabItemView(this);
        itemView.initialize(normalDrawable, selectedDrawable, text);
        itemView.setTextDefaultColor(getResources().getColor(R.color.colorTabBarTextNormal));
        itemView.setTextCheckedColor(getResources().getColor(R.color.colorTabBarTextSelect));
        return itemView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
                default:
                    break;
        }
    }

    /**
     * 获取当前版本号
     */
    private void getCurrentVersionCode(){
        mCurrentVersionCode = AppUtils.getAppVersionCode();
        Log.i("当前版本", mCurrentVersionCode + "");

    }


}
