package contactMS.dao.contacts;
import contactMS.dao.JpaDao;
import contactMS.entity.ContactsEntity;



/**
 * JPA Implementation of a {@link ContactsEntityDao}.
 * 
 */
public class JpaContactsEntityDao extends JpaDao<ContactsEntity, Long> implements ContactsEntityDao
{

	public JpaContactsEntityDao()
	{
		super(ContactsEntity.class);
	}
}
