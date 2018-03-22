package test.com.video.customView;

import android.content.Context;
import android.util.AttributeSet;

import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * 视频播放控件
 * Created by hww on 2018/1/17.
 */

public class VideoPlayerLayout extends StandardGSYVideoPlayer{
    public VideoPlayerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init(Context context) {
        super.init(context);
    }
}
