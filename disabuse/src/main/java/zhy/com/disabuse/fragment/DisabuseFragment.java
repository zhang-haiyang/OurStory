package zhy.com.disabuse.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;

import zhy.com.disabuse.R;
import zhy.com.engine.util.DownLoadApk;

/**
 * 首页解忧碎片
 * Created by hww on 2018/1/16.
 */

public class DisabuseFragment extends Fragment {

    private View mViewV;
    private TextView mUpDateTV;
    private DownLoadApk downLoadApk;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_disabuse, container, false);
        initView();
        initData();
        return mViewV;
    }

    private void initView(){
        mUpDateTV = mViewV.findViewById(R.id.tv_update);
        downLoadApk = new DownLoadApk(getActivity(), "http://file.yirimao.com/2.2.4/app-shuihe.apk");//测试地址
    }

    private void initData(){
        mUpDateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downLoadApk.downloadApk();
            }
        });
    }



}
