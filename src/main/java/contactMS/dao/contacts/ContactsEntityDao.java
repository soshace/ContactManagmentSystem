package contactMS.dao.contacts;

import contactMS.dao.Dao;
import contactMS.entity.ContactsEntity;

/**
 * Definition of a Data Access Object that can perform CRUD Operations for
 * {@link ContactsEntity}s.
 *
 */
public interface ContactsEntityDao extends Dao<ContactsEntity> {
    public String save(ContactsEntity entity);
}
