package school.sorokin.javacore.Reflection.Annotation;

import jdk.jfr.Enabled;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Example example = new Example();
        example.print();

        Class<?> class1 = Example.class;

        Method[] methods = class1.getDeclaredMethods();
        System.out.println(Arrays.toString(methods));

        for (Method met:methods) {
            if (met.isAnnotationPresent(Action.class)) {
                Action action = met.getAnnotation(Action.class);
                System.out.println(met.getName() + " " + action.description());
                met.invoke(example);
            }
        }


    }
}
