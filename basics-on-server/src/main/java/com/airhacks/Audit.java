package com.airhacks;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class Audit {

    @AroundInvoke
    public Object onCall(InvocationContext ic) throws Exception {
        System.out.println("Before call: " + ic.getMethod());
        return ic.proceed();
    }

}
