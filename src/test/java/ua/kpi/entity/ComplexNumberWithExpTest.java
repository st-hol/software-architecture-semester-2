package ua.kpi.entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;
import ua.kpi.entity.impl.ComplexNumberWithExp;

class ComplexNumberWithExpTest {

    private ComplexNumberWithExp complexNumberWithExp;

    @BeforeEach
    void setUp() {
        complexNumberWithExp = createComplexNumberWithExp();
    }

    /**
     * look at console :)
     */
    @Test
    @SuppressWarnings("squid:S2699")
    @DisplayName("task1")
    public void shouldShowConstructorsInvokingOrder() {
        createComplexNumberWithExp();
    }

    @Ignore
    @Test
    @SneakyThrows
    @DisplayName("task2")
    public void shouldInvokeAnnotatedMethods() {
        Method[] methods = complexNumberWithExp.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
//                if (annotation.annotationType().equals(MethodAnnotation.class)
//                        && method.getAnnotation(MethodAnnotation.class).canBeInvoked()) {
//                    String result = method.invoke(complexNumberWithExp).toString();
//                    System.out.println(result);
//
//                    assertNotNull(result);
//                    assertEquals("cos (0) + i sin (0) = e^i*(0)", result);
//                    assertNotEquals("something else", result);
//                }
            }
        }
    }

    @Test
    @SuppressWarnings("squid:S2699")
    @DisplayName("task3")
    void shouldDisplayClassInfo() {
        System.out.println("\n\n\n");

        Package pack = complexNumberWithExp.getClass().getPackage();
        System.out.println(pack.getName());

        Class clazz = complexNumberWithExp.getClass();
        System.out.println(clazz.getSimpleName());

        Arrays.stream(complexNumberWithExp.getClass().getDeclaredMethods())
                .map(method -> {
                    String[] annotations = Arrays.stream(method.getDeclaredAnnotations())
                            .map(Annotation::toString).toArray(String[]::new);
                    String mod = Modifier.toString(method.getModifiers())
                            + " " + method.getReturnType().getSimpleName() + " "
                            + method.getName() + "(" + getMethodParameters(method) + ")";
                    return "\n" + arrayOfAnnotationsPrettyPrint(annotations) + "\n" + mod;
                })
                .forEach(System.out::println);
    }

    private String arrayOfAnnotationsPrettyPrint(Object[] array) {
        return Arrays.toString(array)
                .replace(",", "\n")
                .replace("[", "")
                .replace("]", "")
                .trim();
    }

    private String getMethodParameters(Method method) {
        return Arrays.stream(method.getParameters())
                .map(param -> param.getType() + " " + param.getName())
                .collect(Collectors.joining(","));
    }

    private ComplexNumberWithExp createComplexNumberWithExp() {
        return new ComplexNumberWithExp();
    }
}