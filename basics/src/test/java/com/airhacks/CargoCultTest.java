package com.airhacks;

import java.lang.reflect.Field;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class CargoCultTest {

    @Test
    public void findAnnotation() {
        Field[] declaredFields = CargoCult.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            NoMagic annotation = declaredField.getAnnotation(NoMagic.class);
            if (annotation != null) {
                System.out.println("annotation = " + annotation + " on field " + declaredField + " with value: " + annotation.value());
            } else {
                System.out.println("declaredField = " + declaredField + " is not annotated");
            }
        }
    }

}
