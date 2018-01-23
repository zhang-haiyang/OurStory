package zhy.com.video.daapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.security.InvalidParameterException;

import zhy.com.video.bean.VideoBean;
import zhy.com.video.viewholder.VideoListViewHolder;

/**
 * Created by hww on 2018/1/22.
 */

public class VideoListAdapter extends RecyclerArrayAdapter {


    public static final int TYPE_INVALID = 0;
    public static final int TYPE_VIDEO = 1;
    private Context context;
    public VideoListAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getViewType(int position) {
        Object object = getItem(position);
        if (object instanceof VideoBean){
            return TYPE_VIDEO;
        }
        return TYPE_INVALID;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_VIDEO:
                VideoListViewHolder videoListViewHolder = new VideoListViewHolder(parent);
                videoListViewHolder.setContext(context);
                return videoListViewHolder;
            default:
                throw new InvalidParameterException();
        }
    }
}
