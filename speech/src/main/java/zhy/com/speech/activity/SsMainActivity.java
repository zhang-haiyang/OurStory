package zhy.com.speech.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import zhy.com.speech.R;

public class SsMainActivity extends AppCompatActivity {

    private ImageView mPictureIV;
    private List<LocalMedia> selectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss_main);
        initView();
    }

    private void initView(){
        mPictureIV = findViewById(R.id.iv_picture);


        mPictureIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector.create(SsMainActivity.this)
                        .openGallery(PictureMimeType.ofVideo())
                        .maxSelectNum(9).minSelectNum(1)
                        .selectionMode(2)
                        .previewVideo(true)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case PictureConfig.CHOOSE_REQUEST:
                    String videoUrl = "";
                    selectList = PictureSelector.obtainMultipleResult(data);
                    for (LocalMedia media : selectList){
                        Log.i("图片地址", media.getPath());
                        videoUrl = media.getPath();
                    }
                    Glide.with(this).load(videoUrl).into(mPictureIV);
                    break;
            }
        }
    }
}
