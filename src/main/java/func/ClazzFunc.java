package func;

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

}
