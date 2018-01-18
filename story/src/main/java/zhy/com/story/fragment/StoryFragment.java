package zhy.com.story.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import zhy.com.engine.dialog.VariousDialog;
import zhy.com.engine.dialog.DialogOnClick;
import zhy.com.story.R;

/**
 * 首页故事碎片
 * Created by hww on 2018/1/16.
 */

public class StoryFragment extends Fragment{

    private View mViewV;
    private TextView mStoryTV;

    private Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewV = inflater.inflate(R.layout.fragment_story, container, false);
        initView();
        return mViewV;
    }

    private void initView(){
        mStoryTV = mViewV.findViewById(R.id.tv_story);

        mStoryTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VariousDialog.showAskDialog(getActivity(), "发现有版本更新","建议更新到最新版本",new DialogOnClick() {
                    @Override
                    public void click() {
                        Toast.makeText(getActivity(), "逻辑回调", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


}
