package test.com.engine.bean;

/**
 * 请求返回普通数据的实体类(属性要与后台约定)
 * Created by hww on 2018/1/15.
 */

public class ResponseBean<T> {

    private int status;

    private String message;

    private T data;


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

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
