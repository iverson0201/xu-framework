package other;

import java.lang.reflect.Field;

/**
 * Created by xujw on 2015/8/3.
 */
public class ReflectUtil {

    /**
     * 利用反射获取指定对象的指定属性
     * @param obj 目标对象
     * @param fileName 目标属性
     * @param <T>
     * @return 目标属性的值
     */
    public static <T> T getFieldValue(Object obj,String fileName){
        Object result = null;
        Field field = ReflectUtil.getField(obj,fileName);
        return (T) result;
    }

    private static Field getField(Object obj, String fileName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()){
            try {
                field = clazz.getDeclaredField(fileName);
            } catch (NoSuchFieldException e) {
                //这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
            break;
        }
        return field;
    }
}
