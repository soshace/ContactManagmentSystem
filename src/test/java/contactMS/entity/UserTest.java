package contactMS.entity;

import contactMS.dao.user.UserDao;
import java.util.Collection;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author pabra_000
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:context.xml"})
public class UserTest {
    
    @Autowired
    private UserDao userDao;
    
    private String createdUserId;
    
    private User user;
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.user = new User("test", "test");
        this.createdUserId = this.userDao.save(this.user);
    }
    
    @After
    public void tearDown() {
        this.userDao.delete(this.createdUserId);
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String expResult = this.createdUserId;
        String result = this.user.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "test";
        String result = this.user.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        this.user.setName("test2");
        String expResult = "test2";
        String result = this.user.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoles method, of class User.
     */
    @Test
    public void testSetGetRoles() {
        System.out.println("setRoles");
        this.user.addRole("testRole");
        String expResult = "testRole";
        Set<String> result = this.user.getRoles();
        if(!result.contains(expResult))
            fail("Cant get or set roles");
    }
    
    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = "test";
        String result = this.user.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        this.user.setPassword("test2");
        String expResult = "test2";
        String result = this.user.getPassword();
        assertEquals(expResult, result);
    }
}
