package zhy.com.speech.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zhy.com.speech.R;
import zhy.com.speech.activity.SsMainActivity;

/**
 * 首页言论模块
 * Created by hww on 2018/1/16.
 */

public class SpeechFragment extends Fragment {

    private View mViewV;
    private TextView mSpeechTV;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_speech, container, false);
        initView();
        return mViewV;
    }

    private void initView(){
        mSpeechTV = mViewV.findViewById(R.id.tv_speech);

        mSpeechTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SsMainActivity.class));
            }
        });
    }
}
