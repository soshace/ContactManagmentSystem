package contactMS.dao.contacts;

import contactMS.dao.JpaDao;
import contactMS.entity.ContactsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Mongo Implementation of a {@link ContactsEntityDao}.
 *
 */
public class JpaContactsEntityDao extends JpaDao<ContactsEntity> implements ContactsEntityDao {
    
    @Autowired
    private MongoOperations mongoOperations;
    
    public JpaContactsEntityDao() {
        super(ContactsEntity.class);
    }
    @Override
    public String save(ContactsEntity entity) {
        mongoOperations.save(entity);
        System.out.println(entity.getId());
        return entity.getId();
    }
}
