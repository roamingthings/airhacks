package com.airhacks;

import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Magic(Magic.Kind.WHITE)
@Interceptors(Audit.class)
public class Wizard implements Magician {

    public String performSomeMagic() {
        return "42";
    }

}
