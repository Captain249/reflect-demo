package func;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.time.LocalDate;

import bean.User;
import bean.User.Dog;
import bean.William;
import common.Constant;

/**
 * @author shenzhuojun
 * @version 1.0 2022/10/1 10:21 上午
 * @Description
 */
public class ConstructorFunc {

    // 获取构造方法
    static void getConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        William william;
        // 获取无参构造方法
        Constructor<William> noArgsConstructor = Constant.williamClass.getConstructor();
        william = noArgsConstructor.newInstance();

        // 返回指定参数类型的构造函数对象（public，不包含 private）
        Constructor<William> publicConstructor = Constant.williamClass.getConstructor(String.class, Integer.class, LocalDate.class, Dog.class);
        william = publicConstructor.newInstance("", 0, LocalDate.now(), new User.Dog()); // 需要包含bean.User.Dog的封闭实例

        // 返回指定参数类型的构造函数对象（包含 private）
        Constructor<William> privateConstructor = Constant.williamClass.getDeclaredConstructor(String.class, Integer.class, LocalDate.class);
        privateConstructor.setAccessible(true);
        william = privateConstructor.newInstance("", 0, LocalDate.now());

        // 获取所有构造方法（public，不包含 private）
        Constructor<?>[] constructors = Constant.williamClass.getConstructors();

        // 获取所有构造方法（包含 private）
        Constructor<?>[] declaredConstructors = Constant.williamClass.getDeclaredConstructors();

    }

    public static void otherFunc() {
        Constructor<?>[] declaredConstructors = Constant.williamClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            // 描述此 Constructor 的字符串，
            // 其中包括类型参数 private bean.William(java.lang.String,java.lang.Integer,java.time.LocalDate)
            System.out.println(constructor.toGenericString());

            // Constructor 对象表示的构造方法的类,其实就是返回真实类型（不包含参数）
            Class<?> declaringClass = constructor.getDeclaringClass();

            // 构造函数的形参类型，返回的是 Class 类型
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            // 构造函数的形参类型，返回的是 Type 类型（包含 Class、TypeVariable、WildcardType、ParameterizedType、GenericArrayType）
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
        }
    }

}
