package zhy.com.speech.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zhy.com.speech.R;

/**
 * 首页言论模块
 * Created by hww on 2018/1/16.
 */

public class SpeechFragment extends Fragment {

    private View mViewV;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_speech, container, false);
        return mViewV;
    }
}
