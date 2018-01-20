package zhy.com.story.bean;

import android.widget.ImageView;

/**
 * 故事信息类
 * Created by hww on 2018/1/19.
 */

public class StoryBean {
    public String titil;
    public String summary;
    public String imageString;

    public String getTitil() {
        return titil;
    }

    public void setTitil(String titil) {
        this.titil = titil;
    }

    public String getSumary() {
        return summary;
    }

    public void setSumary(String summary) {
        this.summary = summary;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }
}
