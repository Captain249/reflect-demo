package func;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import bean.William;
import common.Constant;

/**
 * @author shenzhuojun
 * @version 1.0 2022/10/1 10:21 上午
 * @Description
 */
public class FieldFunc {

    // 获取 field
    public static void getFild() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        // 获取 field（不包含 private，包含继承字段）
        Field publicName = Constant.williamClass.getField("publicName");

        // 获取 field（包含 private，不包含继承字段）
        Field privateName = Constant.williamClass.getDeclaredField("privateName");

        // 获取所有 field（不包含 private，包含继承字段）
        Field[] fields = Constant.williamClass.getFields();

        // 获取所有 field（包含 private，不包含继承字段）
        Field[] declaredFields = Constant.williamClass.getDeclaredFields();

    }

    public static void setField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {

        // 设置 public Field 值
        William william = Constant.williamClass.newInstance();
        Field publicNameField = Constant.williamClass.getField("publicName");
        publicNameField.set(william, "william");

        // 设置 private Field 值（父类的 private 字段不能直接获取，需要调用父类的 public 方法）
        Field privateNameField = Constant.williamClass.getDeclaredField("privateName");
        privateNameField.setAccessible(true);
        privateNameField.set(william, "william");

    }

    public static void otherFunc() throws NoSuchFieldException {
        Field privateNameField = Constant.williamClass.getDeclaredField("privateName");

        // 返回 field 属于哪个类 class bean.William
        Class<?> declaringClass = privateNameField.getDeclaringClass();

        // 返回普通 field 的类型 class java.lang.String
        Class<?> type = privateNameField.getType();

        // 返回泛型 field 的类型 T
        Type genericType = privateNameField.getGenericType();
    }

}
