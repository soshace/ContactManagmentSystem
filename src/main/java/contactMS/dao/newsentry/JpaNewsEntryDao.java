package contactMS.dao.newsentry;

import contactMS.dao.JpaDao;
import contactMS.entity.NewsEntry;



/**
 * JPA Implementation of a {@link NewsEntryDao}.
 * 
 */
public class JpaNewsEntryDao extends JpaDao<NewsEntry, Long> implements NewsEntryDao
{

	public JpaNewsEntryDao()
	{
		super(NewsEntry.class);
	}
}
