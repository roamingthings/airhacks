package com.airhacks;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 *
 * @author airhacks.com
 */
public class CargoCultTest {
    // tag::annotation_test[]
    @Test
    public void findAnnotation() {
        Field[] declaredFields = CargoCult.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            NoMagic annotation = declaredField.getAnnotation(NoMagic.class);
            if (annotation != null) {
                System.out.println("annotation = " + annotation + " on field " + declaredField + " with value: " + annotation.value() + " prio " + annotation.priority());
            } else {
                System.out.println("declaredField = " + declaredField + " is not annotated");
            }
        }
    }
    // end::annotation_test[]

}
