package com.airhacks;

import java.lang.reflect.Field;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class WizardTest {

    @Test
    public void cargoCultInjection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.airhacks.Wizard");
        Field[] allFields = clazz.getDeclaredFields();
        for (Field field : allFields) {
            if (field.isAnnotationPresent(Magic.class)) {
                Class<?> typeOfField = field.getType();
                System.out.println("typeOfField = " + typeOfField);
                Object service = typeOfField.newInstance();
                Object client = clazz.newInstance();
                field.set(client, service);
                System.out.println("---- " + client);
            }
        }

    }

}
