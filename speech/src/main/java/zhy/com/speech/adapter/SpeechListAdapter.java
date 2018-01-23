package zhy.com.speech.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.security.InvalidParameterException;

import zhy.com.speech.bean.SpeechBean;
import zhy.com.speech.viewholder.SpeechListViewHolder;

/**
 * Created by hww on 2018/1/22.
 */

public class SpeechListAdapter extends RecyclerArrayAdapter {


    public static final int TYPE_INVALID = 0;
    public static final int TYPE_SPEECH = 1;

    public SpeechListAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {

        Object object = getItem(position);
        if (object instanceof SpeechBean){
            return TYPE_SPEECH;
        }
        return TYPE_INVALID;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_SPEECH:
                SpeechListViewHolder speechListViewHolder = new SpeechListViewHolder(parent);
                return speechListViewHolder;
            default:
                throw new InvalidParameterException();
        }
    }


}
