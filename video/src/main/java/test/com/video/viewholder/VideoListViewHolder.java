package test.com.video.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import test.com.video.R;
import test.com.video.bean.VideoBean;

/**
 * Created by hww on 2018/1/22.
 */

public class VideoListViewHolder extends BaseViewHolder<VideoBean> {

    private Context context;
    public void setContext(Context context) {
        this.context = context;
    }

    private TextView title, summary;
    private ImageView imageView;

    public VideoListViewHolder(ViewGroup parent) {
        super(parent, R.layout.fragment_list_video_item);


        title = $(R.id.tv_story_title);
        summary = $(R.id.tv_story_summary);
        imageView = $(R.id.iv_story_img);
    }

    @Override
    public void setData(VideoBean videoBean) {
        title.setText(videoBean.getVideoTitle());

        summary.setText(videoBean.getVideoSummary());

        Glide.with(context).load(videoBean.getVideoImage()).into(imageView);
    }
}
