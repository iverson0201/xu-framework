package other;

import java.lang.reflect.Field;

/**
 * Created by xujw on 2015/8/3.
 */
public class ReflectUtil {

    /**
     * ���÷����ȡָ�������ָ������
     * @param obj Ŀ�����
     * @param fileName Ŀ������
     * @param <T>
     * @return Ŀ�����Ե�ֵ
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
                //���ﲻ������������û�и��ֶο��ܶ�Ӧ�ĸ����У���û�оͷ���null��
            }
            break;
        }
        return field;
    }
}
