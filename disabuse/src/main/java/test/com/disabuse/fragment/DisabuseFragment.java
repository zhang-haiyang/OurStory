package test.com.disabuse.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import test.com.disabuse.R;
import test.com.engine.util.DownLoadApk;

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
//        downLoadApk = new DownLoadApk(getActivity(), "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=442708598,4076261259&fm=55&s=E3BC2F66D4C178F0193B176F0300F06C&w=121&h=81&img.JPEG");//测试地址

    }

    private void initData(){
        mUpDateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                downLoadApk.downloadApk();
                Toast.makeText(getActivity(), "安装包更新测试，请勿点击", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
