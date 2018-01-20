package zhy.com.story.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import zhy.com.story.R;
import zhy.com.story.bean.StoryBean;

/**
 * Created by hww on 2018/1/19.
 */

public class StoryListViewHolder extends BaseViewHolder<StoryBean> {


    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    private TextView title, summary;
    private ImageView imageView;
    public StoryListViewHolder(ViewGroup parent) {
        super(parent, R.layout.fragment_list_story_item);

        title = $(R.id.tv_story_title);
        summary = $(R.id.tv_story_summary);
        imageView = $(R.id.iv_story_img);
    }

    @Override
    public void setData(StoryBean storyBean) {
        title.setText(storyBean.getTitil());
        summary.setText(storyBean.getSumary());

        Glide.with(context).load(storyBean.getImageString()).into(imageView);

    }
}
