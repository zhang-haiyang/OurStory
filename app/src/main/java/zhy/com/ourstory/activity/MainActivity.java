package zhy.com.ourstory.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import zhy.com.engine.customView.MainTabItemView;
import zhy.com.engine.customView.NoScrollViewPage;
import zhy.com.ourstory.R;
import zhy.com.ourstory.adapter.MainViewPagerAdapter;
import zhy.com.speech.fragment.SpeechFragment;
import zhy.com.story.fragment.StoryFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private NoScrollViewPage mViewPagerVP;
    private MainViewPagerAdapter mAdapter;

    private StoryFragment mStoryFragment;
    private SpeechFragment mSpeechFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView(){
        configViewPager();
        initTabBar();//注意先后顺序
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
        fList.add(mStoryFragment);
        fList.add(mSpeechFragment);

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
                .build();
        navigationController.setupWithViewPager(mViewPagerVP);
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                if (index == 0){
                    Toast.makeText(MainActivity.this, "点击了故事", Toast.LENGTH_SHORT).show();
                }else if (index == 1){
                    Toast.makeText(MainActivity.this, "点击了言论", Toast.LENGTH_SHORT).show();
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

}
