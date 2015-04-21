package contactMS.dao.user;

import contactMS.dao.JpaDao;
import contactMS.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class JpaUserDao extends JpaDao<User> implements UserDao {

    @Autowired
    private MongoOperations mongoOperations;

    public JpaUserDao() {
        super(User.class);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findByName(username);
        if (null == user) {
            throw new UsernameNotFoundException("The user with name " + username + " was not found");
        }
        return user;
    }

    /**
     *
     * @param entity
     * @return
     */
    @Transactional
    public String save(User entity) {
        mongoOperations.save(entity);
        System.out.println(entity.getId());
        return entity.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByName(String name) {
        try {
            return mongoOperations.findOne(Query.query(Criteria.where("name").is(name)), this.entityClass);
        } catch (Exception e) {
            System.out.println("There is no mongodb!");
        }
        return null;
    }

}
