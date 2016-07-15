package com.training;

import com.training.annotation.*;
import com.training.example.TestExample;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    private static List<Class> lowPriorityClases = new ArrayList<>();
    private static List<Class> mediumPriorityClases = new ArrayList<>();
    private static List<Class> highPriorityClases = new ArrayList<>();
    static int passed = 0, failed = 0, count = 0, ignore = 0;


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println("Hello World... ");

        Class<TestExample> clazz = TestExample.class;
        getAuthorInfo(clazz);
        prioritizeExecution();
        allClasesByPriorityFromHightoLow();
    }

    private static void executeMethods(Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PrintPriority.class)) {
                Annotation annotation = method.getAnnotation(PrintPriority.class);
                PrintPriority print = (PrintPriority) annotation;
                try {
                    method.invoke(clazz.newInstance());
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }

            }
            if (method.isAnnotationPresent(Test.class)) {
                Annotation annotation = method.getAnnotation(Test.class);
                Test test = (Test) annotation;

                if (test.enabled()) {
                    try {
                        method.invoke(clazz.newInstance());
                        System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                        passed++;
                    } catch (Throwable e) {
                        System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), e.getCause());
                        failed++;
                    }
                } else {
                    System.out.printf("%s - Test '%s' - ignored %n", ++count, method.getName());
                    ignore++;
                }
            }
        }
    }

    private static void getAuthorInfo(Class<TestExample> clazz) {
        if (clazz.isAnnotationPresent(Author.class)) {
            Annotation annotation = clazz.getAnnotation(Author.class);

            Author author = (Author) annotation;

            System.out.printf("%nPriority :%s", author.priority());
            System.out.printf("%nCreatedBy :%s", author.createdBy());
            System.out.printf("%nTags :");

            int tagLength = author.tags().length;
            for (String tag : author.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%nLastModified :%s%n%n", author.lastModified());
        }
    }

    private static void prioritizeExecution() {
        Reflections reflections = new Reflections("com.training.example");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(ExecutionPriority.class);

        for (Class<?> clazz : annotated) {
            if(clazz.isAnnotationPresent(Skip.class)) {
                Skip annotation = clazz.getAnnotation(Skip.class);
                if(annotation.ignore()) {
                    System.out.println("Skipping: " + clazz.getSimpleName());
                    continue;
                }
            }

            if (clazz.isAnnotationPresent(ExecutionPriority.class)) {
                Annotation annotation = clazz.getAnnotation(ExecutionPriority.class);

                ExecutionPriority executionPriority = (ExecutionPriority) annotation;
                switch (executionPriority.priority()) {
                    case HIGH:
                        highPriorityClases.add(clazz);
                        break;
                    case LOW:
                        lowPriorityClases.add(clazz);
                        break;
                    case MEDIUM:
                        mediumPriorityClases.add(clazz);
                }
            }
        }
    }

    static void allClasesByPriorityFromHightoLow() {
        highPriorityClases.forEach(Main::executeMethods);
        mediumPriorityClases.forEach(Main::executeMethods);
        lowPriorityClases.forEach(Main::executeMethods);
    }
}
