package func;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import bean.User;
import common.Constant;

/**
 * @author shenzhuojun
 * @version 1.0 2022/10/1 10:21 上午
 * @Description
 */
public class MethodFunc {

    // 获取方法
    public static void getMethod() throws NoSuchMethodException {
        // 获取 public 方法
        Method[] methods = Constant.williamClass.getMethods();

        // 获取指定 public 方法
        Method work = Constant.williamClass.getMethod("work", String.class);

        // 获取所有方法，不继承父类
        Method[] declaredMethods = Constant.williamClass.getDeclaredMethods();

        // 获取指定方法，不继承父类
        Method privateMethod = Constant.williamClass.getDeclaredMethod("privateMethod", String.class);
        privateMethod.setAccessible(true);
    }

    // 调用方法
    public static void invoke() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Method getDate = Constant.userClazz.getMethod("getDate");
        Method setData = Constant.userClazz.getMethod("setData", Object.class);
        // 普通返回
        Class<?> returnType = getDate.getReturnType();
        // 泛型返回
        Type genericReturnType = getDate.getGenericReturnType();
        // 普通入参
        Class<?>[] parameterTypes = setData.getParameterTypes();
        // 泛型入参
        Type[] genericParameterTypes = setData.getGenericParameterTypes();
        // 方法调用
        setData.setAccessible(true);
        setData.invoke(Constant.userClazz.newInstance(), new User());
    }

}
