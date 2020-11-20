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

    public static Integer parseIntDefault(String string, Integer def) {
        if (string == null) {
            return def;
        }
        Integer integer = def;
        try {
            integer = Integer.parseInt(string);
        } catch (NumberFormatException ignored) {
        }
        return integer;
    }
}
