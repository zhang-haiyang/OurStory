package test.com.video.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import test.com.video.R;
import test.com.video.activity.OpenVideoActivity;
import test.com.video.bean.VideoBean;
import test.com.video.daapter.VideoListAdapter;

/**
 * 首页视频碎片
 * Created by hww on 2018/1/17.
 */

public class VideoFragment extends Fragment {

    private View mViewV;
//    private TextView textView;

    private EasyRecyclerView mEasyRecyclerView;
    private VideoListAdapter mAdapter;
    private List<VideoBean> vList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_video, container, false);

        initView();
        return mViewV;
    }

    private void initView(){
//        textView = mViewV.findViewById(R.id.tv_open_video);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), OpenVideoActivity.class);
//                startActivity(intent);
//            }
//        });
        configRecyclerView();
        testData();
    }

    private void configRecyclerView(){
        mEasyRecyclerView = mViewV.findViewById(R.id.erv_video);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mEasyRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new VideoListAdapter(getActivity());
        mEasyRecyclerView.setAdapterWithProgress(mAdapter);


        mAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(getActivity(), OpenVideoActivity.class));
            }
        });

    }

    private void testData(){

        for (int i = 0; i < 50; i++){
            VideoBean videoBean = new VideoBean();
            videoBean.setVideoTitle("第" + (i + 1) + "个视频");

            videoBean.setVideoImage("http://static.statickksmg.com/image/2015/11/13/210e8e32e9f3f3c45c0d353711642742.jpg");

            videoBean.setVideoSummary("第" + (i + 1) + "个视频的简介：XXXXXX");

            vList.add(videoBean);
        }
        mAdapter.addAll(vList);

    }


}
