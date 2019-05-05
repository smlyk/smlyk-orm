package javax.core.common;

import java.io.Serializable;

/**
 * @author yekai
 */
public class ResultMsg<T> implements Serializable{

    /**
     * 状态码，系统的返回码
     */
    private int status;

    /**
     * 系统返回的状态码信息
     */
    private String msg;

    /**
     * 系统返回的结果
     */
    private T data;

    public ResultMsg(){}

    public ResultMsg(int status) {
        this.status = status;
    }

    public ResultMsg(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultMsg(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResultMsg(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
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
}
