package contactMS.dao;

import contactMS.dao.contacts.ContactsEntityDao;
import contactMS.dao.user.UserDao;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Initialize the database with some test entries.
 *
 */
public class DataBaseInitializer {
    
    private final ContactsEntityDao contactsEntityDao;

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    public DataBaseInitializer(UserDao userDao, ContactsEntityDao contactsEntityDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;

        this.passwordEncoder = passwordEncoder;
        
        this.contactsEntityDao = contactsEntityDao;
    }

    public void initDataBase() {
        /*User userUser = new User("pabragin", this.passwordEncoder.encode("12345"));
        userUser.addRole("user");
        userUser.addRole("admin");
        userDao.save(userUser);
        
        User userGuest = new User("guest", this.passwordEncoder.encode("guest"));
        userUser.addRole("user");
        userDao.save(userGuest);
        
        ContactsEntity myContact = new ContactsEntity("Pavel", "Bragin", "+79811706016", "This is my number");
        contactsEntityDao.save(myContact);*/
    }
}
