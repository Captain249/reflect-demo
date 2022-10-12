package bean;

/**
 * @author shenzhuojun
 * @version 1.0 2022/10/8 1:57 下午
 * @Description
 */
public class Genericity<T> {

    public T data;

    public T getDate() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
