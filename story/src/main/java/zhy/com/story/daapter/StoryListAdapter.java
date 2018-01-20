package zhy.com.story.daapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.security.InvalidParameterException;

import zhy.com.story.bean.StoryBean;
import zhy.com.story.viewholder.StoryListViewHolder;

/**
 * Created by hww on 2018/1/19.
 */

public class StoryListAdapter extends RecyclerArrayAdapter {
    public static final int TYPE_INVALID = 0;
    public static final int TYPE_STORY = 1;
    private Context context;
    public StoryListAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getViewType(int position) {
        Object object = getItem(position);
        if (object instanceof StoryBean){
            return TYPE_STORY;
        }
        return TYPE_INVALID;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_STORY:
                StoryListViewHolder storyListViewHolder = new StoryListViewHolder(parent);
                storyListViewHolder.setContext(context);
                return storyListViewHolder;
            default:
                throw new InvalidParameterException();
        }
    }
}
