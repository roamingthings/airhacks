package com.airhacks;

import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Interceptors(Audit.class)
public class Wizard {

    public String performSomeMagic() {
        return "42";
    }

}
