package contactMS.entity;

import contactMS.dao.contacts.ContactsEntityDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ContactsEntityTest {
    
    @Autowired
    private ContactsEntityDao contactsEntityDao;
    
    private String createdUserId;
    
    private ContactsEntity contactsEntity;
    
    public ContactsEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.contactsEntity = new ContactsEntity("Pavel", "Bragin", "+79811706016", "test19191919");
        this.createdUserId = this.contactsEntityDao.save(this.contactsEntity);
    }
    
    @After
    public void tearDown() {
        this.contactsEntityDao.delete(this.createdUserId);
    }

    /**
     * Test of getId method, of class ContactsEntity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String expResult = this.createdUserId;
        String result = this.contactsEntity.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class ContactsEntity.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Pavel";
        String result = this.contactsEntity.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class ContactsEntity.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        this.contactsEntity.setFirstName("Nikita");
        String expResult = "Nikita";
        String result = this.contactsEntity.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class ContactsEntity.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Bragin";
        String result = this.contactsEntity.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class ContactsEntity.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        this.contactsEntity.setLastName("Ivanov");
        String expResult = "Ivanov";
        String result = this.contactsEntity.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class ContactsEntity.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        String expResult = "+79811706016";
        String result = this.contactsEntity.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhoneNumber method, of class ContactsEntity.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        this.contactsEntity.setPhoneNumber("+79811706015");
        String expResult = "+79811706015";
        String result = this.contactsEntity.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdditionalInformation method, of class ContactsEntity.
     */
    @Test
    public void testGetAdditionalInformation() {
        System.out.println("getAdditionalInformation");
        String expResult = "test19191919";
        String result = this.contactsEntity.getAdditionalInformation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalInformation method, of class ContactsEntity.
     */
    @Test
    public void testSetAdditionalInformation() {
        System.out.println("setAdditionalInformation");
        this.contactsEntity.setPhoneNumber("test18181818");
        String expResult = "test18181818";
        String result = this.contactsEntity.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ContactsEntity.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = String.format("ContactEntity[%s, %s, %s, %s, %s]", this.contactsEntity.getId(), this.contactsEntity.getFirstName(), this.contactsEntity.getLastName(), this.contactsEntity.getPhoneNumber(), this.contactsEntity.getAdditionalInformation());;
        String result = this.contactsEntity.toString();
        assertEquals(expResult, result);
    }
    
}
