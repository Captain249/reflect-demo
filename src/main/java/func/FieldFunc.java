package func;

import java.lang.reflect.Field;

import common.Constant;

/**
 * @author shenzhuojun
 * @version 1.0 2022/10/1 10:21 上午
 * @Description
 */
public class FieldFunc {

    // 获取 field
    public static void getFild() throws NoSuchFieldException {
        // 获取 field（不包含 private，包含继承字段）
        Field publicName = Constant.williamClass.getField("publicName");

        // 获取 field（包含 private，不包含继承字段）
        Field privateName = Constant.williamClass.getDeclaredField("privateName");

        // 获取所有 field（不包含 private，包含继承字段）
        Field[] fields = Constant.williamClass.getFields();

        // 获取所有 field（包含 private，不包含继承字段）
        Field[] declaredFields = Constant.williamClass.getDeclaredFields();

    }

}
