package zhy.com.video.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zhy.com.video.R;
import zhy.com.video.activity.OpenVideoActivity;
import zhy.com.video.activity.WqqMainActivity;

/**
 * 首页视频碎片
 * Created by hww on 2018/1/17.
 */

public class VideoFragment extends Fragment {

    private View mViewV;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_video, container, false);

        initView();
        return mViewV;
    }

    private void initView(){
        textView = mViewV.findViewById(R.id.tv_open_video);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OpenVideoActivity.class);
                startActivity(intent);
            }
        });
    }
}
