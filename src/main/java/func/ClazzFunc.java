package func;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import bean.*;
import bean.William;
import common.Constant;

/**
 * @author shenzhuojun
 * @version 1.0 2022/10/1 10:20 上午
 * @Description
 */
@SuppressWarnings("unchecked")
public class ClazzFunc {

    // 获取 Class 对象
    static void getClazz() throws ClassNotFoundException {
        User user = new User();
        Class<User> clazz_1 = (Class<User>) Class.forName("bean.User");
        Class<User> clazz_2 = User.class;
        Class<? extends User> clazz_3 = user.getClass();
    }

    // 获取 Class 对象的名称
    static void getClazzName() {
        // 全限定类名 bean.User$Dog 可以用于动态加载 Class 对象，Class.forName。
        String name = Constant.dogClazz.getName();
        System.out.println(name);
        // 全限定的类名 普通类和 getName() 没区别，内部类有区别，bean.User.Dog
        String canonicalName = Constant.dogClazz.getCanonicalName();
        System.out.println(canonicalName);
        // 类名
        String simpleName = Constant.dogClazz.getSimpleName();
        System.out.println(simpleName);
    }

    // 获取 class 的实例
    static void getInstance() throws InstantiationException, IllegalAccessException {
        // 调用无参构造
        User user = Constant.userClazz.newInstance();
    }

    // 其他方法
    static void otherFunc() {
        // 是否是一个接口
        boolean anInterface = Constant.userClazz.isInterface();
        System.out.println(anInterface);

        // 获取直接基类 User
        Class<? super William> superclass = Constant.williamClass.getSuperclass();
        System.out.println(superclass.getSimpleName());
    }

    static void getGenericity_step_01() throws Exception {
        // 先按正常的脑回路，试下拿到的泛型，发现屁都拿不到。
        Genericity<String> stringGenericity = new Genericity<>();
        Class<? extends Genericity> clazz = stringGenericity.getClass();
        Field dataField = clazz.getDeclaredField("data");
        System.out.println(dataField);
        // public java.lang.Object bean.Genericity.data
        System.out.println(dataField.getType());
        // class java.lang.Object
        System.out.println(dataField.getGenericType());
        // T
    }

    static void getGenericity_step_02() {
        ChildGenericity childGenericity = new ChildGenericity();
        Class<? extends ChildGenericity> clazz = childGenericity.getClass();
        ParameterizedType genericSuperclass = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument);
        }
    }

    static void getGenericity_step_03() {
        System.out.println(new Genericity<String>().getClass().getGenericSuperclass());
        System.out.println(new Genericity<String>() {}.getClass().getGenericSuperclass());
    }

    static void getGenericity_step_04() {
        new TypeToken<Genericity<String>>() {}.parseGenericInfo();
    }


}
