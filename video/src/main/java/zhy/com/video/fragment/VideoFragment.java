package zhy.com.video.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zhy.com.video.R;

/**
 * 视频碎片
 * Created by hww on 2018/1/17.
 */

public class VideoFragment extends Fragment {

    private View mViewV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_video, container, false);
        return mViewV;
    }
}
