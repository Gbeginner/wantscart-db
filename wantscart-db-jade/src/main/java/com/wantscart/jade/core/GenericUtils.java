package com.wantscart.jade.core;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现工具类，检查参数化类型的参数类型。
 * 
 * @author han.liao
 */
public class GenericUtils {

    public static final Class<?>[] EMPTY_CLASSES = new Class<?>[0];

    /**
     * 从参数, 返回值, 基类的: Generic 类型信息获取传入的实际类信息。
     * 
     *  genericType - Generic 类型信息
     * 
     *  实际类信息
     */
    public static Class<?>[] getActualClass(Type genericType) {

        if (genericType instanceof ParameterizedType) {

            Type[] actualTypes = ((ParameterizedType) genericType).getActualTypeArguments();
            Class<?>[] actualClasses = new Class<?>[actualTypes.length];

            for (int i = 0; i < actualTypes.length; i++) {
                Type actualType = actualTypes[i];
                if (actualType instanceof Class<?>) {
                    actualClasses[i] = (Class<?>) actualType;
                } else if (actualType instanceof GenericArrayType) {
                    Type componentType = ((GenericArrayType) actualType).getGenericComponentType();
                    actualClasses[i] = Array.newInstance((Class<?>) componentType, 0).getClass();
                }
            }

            return actualClasses;
        }

        return EMPTY_CLASSES;
    }

    /**
     * 收集类的所有常量。
     * 
     *  clazz - 收集目标
     *  findAncestor - 是否查找父类
     *  findInterfaces - 是否查找接口
     * 
     *  {@link Map} 包含类的所有常量
     */
    public static Map<String, ?> getConstantFrom(Class<?> clazz, // NL
            boolean findAncestor, boolean findInterfaces) {

        HashMap<String, Object> map = new HashMap<String, Object>();

        if (findInterfaces) {
            for (Class<?> interfaceClass : clazz.getInterfaces()) {
                fillConstantFrom(interfaceClass, map);
            }
        }

        if (findAncestor) {
            Class<?> superClass = clazz;
            while (superClass != null) {
                fillConstantFrom(superClass, map);
                superClass = superClass.getSuperclass();
            }
        }

        fillConstantFrom(clazz, map);

        return map;
    }

    // 填充静态常量
    protected static void fillConstantFrom(Class<?> clazz, HashMap<String, Object> map) {

        Field fields[] = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isSynthetic()) {
                continue; // 忽略系统常量
            }

            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                continue; // 忽略非静态常量
            }

            try {
                if (field.isAccessible()) {
                    field.setAccessible(true);
                }
                map.put(field.getName(), field.get(null));

            } catch (SecurityException e) {
                // Do nothing
            } catch (IllegalAccessException e) {
                // Do nothing
            }
        }
    }
}
