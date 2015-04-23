package contactMS.dao.user;

import contactMS.entity.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:context.xml"})
public class JpaUserDaoTest {
    
    @Autowired
    private UserDao userDao;
    
    private String userId;
    
    public JpaUserDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        User newUser = new User("test181818", "test");
        newUser.addRole("user");
        userId = userDao.save(newUser);
    }
    
    @After
    public void tearDown() {
        userDao.delete(userId);
    }

    /**
     * Test of loadUserByUsername method, of class JpaUserDao.
     */
    @Test
    public void testLoadUserByUsername() {
        System.out.println("loadUserByUsername");
        try
        {
            this.userDao.loadUserByUsername("test181818");
        }catch(UsernameNotFoundException ue)
        {
            fail("Cant load user by Username");
        }            
    }

    /**
     * Test of findByName method, of class JpaUserDao.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        User findUser = this.userDao.findByName("test181818");
        if(!findUser.getId().equalsIgnoreCase(userId))
            fail("Cant load user by User name");
    }
    
}
