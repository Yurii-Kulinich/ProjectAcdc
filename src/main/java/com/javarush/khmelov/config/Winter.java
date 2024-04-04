package com.javarush.khmelov.config;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Winter {

    private static final Map<Class<?>, Object> components = new HashMap<>();

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public static <T> T find(Class<T> aClass) {
        Object component = components.get(aClass);
        if (component == null) {
            Constructor<?> constructor = aClass.getConstructors()[0];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] parameters = new Object[parameterTypes.length];
            for (int i = 0; i < parameters.length; i++) {
                parameters[i] = Winter.find(parameterTypes[i]);
            }
            Object newInstance = constructor.newInstance(parameters);
            components.put(aClass, newInstance);
        }
        return (T) components.get(aClass);

    }
}
