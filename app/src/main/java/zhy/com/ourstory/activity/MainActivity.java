package zhy.com.ourstory.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.AppUtils;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import zhy.com.disabuse.fragment.DisabuseFragment;
import zhy.com.engine.customView.MainTabItemView;
import zhy.com.engine.customView.NoScrollViewPage;
import zhy.com.ourstory.R;
import zhy.com.ourstory.adapter.MainViewPagerAdapter;
import zhy.com.speech.fragment.SpeechFragment;
import zhy.com.story.fragment.StoryFragment;
import zhy.com.video.fragment.VideoFragment;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
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
                    Toast.makeText(MainActivity.this, "点击了故事", Toast.LENGTH_SHORT).show();
                }else if (index == 1){
                    Toast.makeText(MainActivity.this, "点击了言论", Toast.LENGTH_SHORT).show();
                }else if (index == 2){
                    Toast.makeText(MainActivity.this, "点击了解忧", Toast.LENGTH_SHORT).show();
                }else if (index == 3){
                    Toast.makeText(MainActivity.this, "点击了视频", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onRepeat(int index) {

            }
        });
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
