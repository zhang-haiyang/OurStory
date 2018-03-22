package test.com.story.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import test.com.story.R;
import test.com.story.activity.StoryDetailActivity;
import test.com.story.bean.StoryBean;
import test.com.story.daapter.StoryListAdapter;

/**
 * 首页故事碎片
 * Created by hww on 2018/1/16.
 */

public class StoryFragment extends Fragment{

    private View mViewV;

    private Dialog dialog;

    private EasyRecyclerView mEasyRecyclerView;
    private StoryListAdapter mAdapter;
    private List<StoryBean> sList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_story, container, false);
        initView();
        return mViewV;
    }

    private void initView(){
        configRecyclerView();
        testData();
//        mStoryTV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                VariousDialog.showAskDialog(getActivity(), "点击确定看故事","是否看一下这篇故事",new DialogOnClick() {
//                    @Override
//                    public void click() {
//                        startActivity(new Intent(getActivity(), StoryDetailActivity.class));
//                    }
//                });
//            }
//        });
    }

    private void configRecyclerView(){
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mEasyRecyclerView = mViewV.findViewById(R.id.erv_story);
        mEasyRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new StoryListAdapter(getActivity());
        mEasyRecyclerView.setAdapterWithProgress(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(getActivity(), StoryDetailActivity.class));
            }
        });


    }

    private void testData(){

        for (int i = 0; i < 50; i++){
            StoryBean storyBean = new StoryBean();
            if (i == 0){
                storyBean.setTitil("第" + (i + 1) + "个故事标题个故事标题个故事标题个故事标题(本页面使用瀑布流)");
            }else {
                storyBean.setTitil("第" + (i + 1) + "个故事标题");
            }
            storyBean.setImageString("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=568496516,791684687&fm=27&gp=0.jpg");

            if (i == 8){
                storyBean.setSumary("第" + (i + 1) + "个故事的简介：XXXXXX9999999999999999999999(本页面使用瀑布流)");
            }else {
                storyBean.setSumary("第" + (i + 1) + "个故事的简介：XXXXXX");
            }
            sList.add(storyBean);
        }
        mAdapter.addAll(sList);

    }


}
