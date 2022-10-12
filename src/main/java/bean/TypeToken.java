package bean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author shenzhuojun
 * @version 1.0 2022/10/12 9:07 下午
 * @Description
 */
public abstract class TypeToken<T> {

    public void parseGenericInfo() {
        // Token<Genericity<java.lang.String>>
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        // Genericity<java.lang.String>
        ParameterizedType targetGenericClass = (ParameterizedType) genericSuperclass.getActualTypeArguments()[0];
        // 原始类型 class Genericity
        Class targetClass = (Class) targetGenericClass.getRawType();

        for (int i = 0; i < targetGenericClass.getActualTypeArguments().length; i++) {
            System.out.println(targetClass.getTypeParameters()[i] + " -> " + targetGenericClass.getActualTypeArguments()[i]);
        }
    }
}
