package zhy.com.engine.bean;

import java.util.List;

/**
 * 请求返回列表数据的实体类(属性要与后台约定)
 * Created by hww on 2018/1/15.
 */

public class ResponseListBean<T> {

    private int status;

    private String message;

    private List<T> data;

    //分页属性应该不需要


    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
}
