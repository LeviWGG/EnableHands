package app.main.wangliwei.enablehands.bean;


import app.main.wangliwei.enablehands.http.BaseObserver;

public class HttpResult<T> {
    private int status;
    private String msg;
    private T data;

    public HttpResult() {
    }

    public HttpResult(String msg) {
        this.status = BaseObserver.HTTP_STATUS_DEFAULT_ERROR;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

