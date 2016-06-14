package com.airhacks.tight.contact.boundary;

import com.airhacks.tight.contact.entity.Contact;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class ContactsService {

    @PersistenceContext
    EntityManager em;

    public Contact saveOrUpdate(Contact contact) {
        Contact retVal = em.merge(contact);
        this.em.flush();
        this.em.refresh(retVal);
        return retVal;
    }

    public String street() {
        return "effective";
    }

}
