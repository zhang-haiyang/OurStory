package test.com.engine.customView;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 不可以滑动的ViewPager
 */
public class NoScrollViewPage extends ViewPager {
    private boolean noScroll = false;
    /**
     * 上一次x坐标
     */
    private float beforeX;
    private int xDown, xUp, yDown, yUp;

    private int pageIndex;
    private OnTouchListener onTouchListener;

    public void setIndex(int index) {
        this.pageIndex = index;
    }

    public NoScrollViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public NoScrollViewPage(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (noScroll)
            return false;
        else
            return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int index = getCurrentItem();
        if (noScroll) {
            return super.dispatchTouchEvent(ev);
        } else {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN://按下如果‘仅’作为‘上次坐标’，不妥，因为可能存在左滑，motionValue大于0的情况（来回滑，只要停止坐标在按下坐标的右边，左滑仍然能滑过去）
                    beforeX = ev.getX();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float motionValue = ev.getX() - beforeX;
                    if (motionValue > 0 && index == 1 && pageIndex == 0) {//禁止左滑
                        return true;
                    }
                    beforeX = ev.getX();//手指移动时，再把当前的坐标作为下一次的‘上次坐标’，解决上述问题
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                default:
                    break;
            }
            if (onTouchListener != null) {
                onTouchListener.onTouch(this, ev);
            }
            return super.dispatchTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (noScroll){
            return false;
        } else {
            return super.onInterceptTouchEvent(event);
        }
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
        onTouchListener = l;
    }
}