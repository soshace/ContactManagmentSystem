package contactMS.dao.user;

import contactMS.dao.Dao;
import contactMS.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDao extends Dao<User>, UserDetailsService {

    User findByName(String name);

    String save(User user);

}
