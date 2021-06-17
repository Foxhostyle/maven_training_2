package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class TestClassDescription {
    final Class<?> aClass;

    TestClassDescription(Class<?> getClass) {
        this.aClass = getClass;

    }

    public List<Method> listTestMethods() {
        return Arrays.stream(aClass.getDeclaredMethods())
            .filter(mod -> mod.isAnnotationPresent(TestMethod.class))
            .filter(mod -> Modifier.isPublic(mod.getModifiers()))
            .filter(mod -> mod.getReturnType() == void.class)
            .filter(mod -> mod.getParameterCount() == 0)
            .toList();
    }
}
