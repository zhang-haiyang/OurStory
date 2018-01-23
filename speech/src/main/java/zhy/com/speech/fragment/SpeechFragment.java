package zhy.com.speech.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zhy.com.speech.R;
import zhy.com.speech.activity.SsMainActivity;
import zhy.com.speech.adapter.SpeechListAdapter;
import zhy.com.speech.bean.SpeechBean;

/**
 * 首页言论模块
 * Created by hww on 2018/1/16.
 */

public class SpeechFragment extends Fragment {

    private View mViewV;
//    private TextView mSpeechTV;
    private EasyRecyclerView mEasyRecyclerView;
    private SpeechListAdapter mAdapter;
    private List<SpeechBean> sList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_speech, container, false);
        initView();
        return mViewV;
    }

    private void initView(){
//        mSpeechTV = mViewV.findViewById(R.id.tv_speech);
//
//        mSpeechTV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), SsMainActivity.class));
//            }
//        });
        configRecyclerView();
        testData();
    }

    private void configRecyclerView(){
        mEasyRecyclerView = mViewV.findViewById(R.id.erv_speech);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mEasyRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new SpeechListAdapter(getActivity());
        mEasyRecyclerView.setAdapterWithProgress(mAdapter);

    }

    private void testData(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm");
        String beijingTime = sdf.format(date);

        for (int i = 0; i < 50; i++){
            SpeechBean speechBean = new SpeechBean();
            speechBean.setTime(beijingTime);
            speechBean.setSpeechType("第" + i + "种类型");
            speechBean.setContent("能够被称为经典的书籍，无一不是那个时代的先锋，当今畅销书玲琅满目，能够称为先锋的寥寥无几，我们时间是有限的，应该用这有限的时间去阅读最伟大的作品");
            sList.add(speechBean);
        }
        mAdapter.addAll(sList);
    }
}
