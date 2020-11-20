package com.tianyisoft.mymoney.util;

import java.lang.reflect.Field;

/**
 * @author tianyi
 */
public class Utils {
    public static Object getFieldValueFromObject(Object object, String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return field.get(object);
    }
}
