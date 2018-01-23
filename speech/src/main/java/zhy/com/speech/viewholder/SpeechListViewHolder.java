package zhy.com.speech.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import zhy.com.speech.R;
import zhy.com.speech.bean.SpeechBean;

/**
 * Created by hww on 2018/1/23.
 */

public class SpeechListViewHolder extends BaseViewHolder<SpeechBean> {


    private TextView mTimeTV, mTypeTV, mContentTV;

    public SpeechListViewHolder(ViewGroup parent) {
        super(parent, R.layout.fragment_list_speech_item);

        mTypeTV = $(R.id.tv_speech_type);
        mContentTV = $(R.id.tv_speech_content);
        mTimeTV = $(R.id.tv_speech_time);
    }

    @Override
    public void setData(SpeechBean speechBean) {
        mTypeTV.setText(speechBean.getSpeechType());
        mContentTV.setText(speechBean.getContent());
        mTimeTV.setText(speechBean.getTime());
    }
}
