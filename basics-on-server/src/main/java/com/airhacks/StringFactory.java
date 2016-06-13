package com.airhacks;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class StringFactory {

    @Produces
    @MyConfiguration
    public String configurable(InjectionPoint ip) {
        Annotated annotated = ip.getAnnotated();
        MyConfiguration annotation = annotated.getAnnotation(MyConfiguration.class);
        System.out.println("annotation " + annotation.value());
        Class<?> clazz = ip.getMember().getDeclaringClass();
        String fieldName = ip.getMember().getName();
        return clazz.getName() + "->" + fieldName + " -->" + System.currentTimeMillis();
    }

}
