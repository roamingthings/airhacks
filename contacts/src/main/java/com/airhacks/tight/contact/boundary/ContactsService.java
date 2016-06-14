package com.airhacks.tight.contact.boundary;

import com.airhacks.tight.contact.entity.Contact;
import com.airhacks.tight.security.boundary.EntitlementEnforcement;
import com.airhacks.tight.security.boundary.Entitlements;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Interceptors(EntitlementEnforcement.class)
public class ContactsService {

    @PersistenceContext
    EntityManager em;

    @Entitlements("whatever")
    public Contact saveOrUpdate(Contact contact) {

        Contact retVal = em.merge(contact);
        this.em.flush();
        this.em.refresh(retVal);
        return retVal;
    }

    @Entitlements("want")
    public String street() {
        return "effective";
    }

}
