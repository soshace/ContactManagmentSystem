package contactMS.dao;

import java.util.Date;

import contactMS.dao.newsentry.NewsEntryDao;
import contactMS.dao.user.UserDao;
import contactMS.entity.NewsEntry;
import contactMS.entity.User;

import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Initialize the database with some test entries.
 * 
 */
public class DataBaseInitializer
{

	private NewsEntryDao newsEntryDao;

	private UserDao userDao;

	private PasswordEncoder passwordEncoder;

	public DataBaseInitializer(UserDao userDao, NewsEntryDao newsEntryDao, PasswordEncoder passwordEncoder)
	{
            this.newsEntryDao = newsEntryDao;

            this.userDao = userDao;

            this.passwordEncoder = passwordEncoder;
	}


	public void initDataBase()
	{
		User userUser = new User("user", this.passwordEncoder.encode("user"));
		userUser.addRole("user");
		this.userDao.save(userUser);

		User adminUser = new User("admin", this.passwordEncoder.encode("admin"));
		adminUser.addRole("user");
		adminUser.addRole("admin");
		this.userDao.save(adminUser);

		long timestamp = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
		for (int i = 0; i < 10; i++) {
			NewsEntry newsEntry = new NewsEntry();
			newsEntry.setContent("This is example content " + i);
			newsEntry.setDate(new Date(timestamp));
			this.newsEntryDao.save(newsEntry);
			timestamp += 1000 * 60 * 60;
		}
	}

}