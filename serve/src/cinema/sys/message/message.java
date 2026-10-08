package cinema.sys.message;

import java.io.Serializable;

//不确定数据类型，用泛型T
public class message<T> implements Serializable {//用于信息交互
    private String action;//行为
    private T data;//数据

    @Override
    public String toString() {
        return action+"->"+data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public T getData() {
        return data;
    }

    public message() {
    }

    public message(String action, T data) {
        this.action = action;
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
