package com.airhacks.tight.security.boundary;

import com.airhacks.tight.security.entity.AirhacksPrincipal;
import java.lang.reflect.Method;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class EntitlementEnforcement {

    @Inject
    AirhacksPrincipal principal;

    @AroundInvoke
    public Object check(InvocationContext ic) throws Exception {
        Method method = ic.getMethod();
        System.out.println("Checking = " + method);
        Entitlements annotation = method.getAnnotation(Entitlements.class);
        if (annotation != null) {
            String entitlement = annotation.value();
            if (principal.isAllowed(entitlement)) {
                return ic.proceed();
            }
        }
        throw new SecurityException("Call me later");
    }

}
