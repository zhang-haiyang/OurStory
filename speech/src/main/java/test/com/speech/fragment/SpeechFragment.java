package test.com.speech.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iceteck.silicompressorr.SiliCompressor;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import test.com.speech.R;
import test.com.speech.adapter.SpeechListAdapter;
import test.com.speech.bean.SpeechBean;

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

        mAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                PictureSelector.create(getActivity())
                        .openGallery(PictureMimeType.ofAll()).isGif(true).isCamera(false).previewImage(false).previewVideo(false).maxSelectNum(9)
                        .minSelectNum(1).forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Log.i("视频路径：原视频", "进入");
            Toast.makeText(getActivity(), "sdsd", Toast.LENGTH_SHORT).show();
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    String videoPath = selectList.get(0).getPath();
                    Log.i("视频路径：原视频", videoPath);

                    String smallVideoPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/yzbCrop";
                    try {
                        String filePath = SiliCompressor.with(getActivity()).compressVideo(videoPath, smallVideoPath);
                        Log.i("视频路径：压缩视频", filePath);
                        File file = new File(filePath);
                        double numLength = (double)(file.length() + 1) / (1024 * 1024);
                        Log.i("视频路径：压缩视频大小", numLength + "");
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
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
