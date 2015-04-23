package contactMS.dao.contacts;

import contactMS.entity.ContactsEntity;
import java.util.List;
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
public class JpaContactsEntityDaoTest {
    
    @Autowired
    private ContactsEntityDao contactsEntityDao;
    
    public JpaContactsEntityDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of findAll method, of class JpaContactsEntityDao.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List<ContactsEntity> allEntries = this.contactsEntityDao.findAll();
        if(allEntries == null)
            fail("Cant find contacts entries");
    }
    
    @Test
    public void testSave() {
        System.out.println("Save");
        ContactsEntity entity = new ContactsEntity("Pavel", "Bragin", "+79811706016", "test19191919");
        String id = this.contactsEntityDao.save(entity);
        List<ContactsEntity> allEntries = this.contactsEntityDao.findAll();
        for(int i =0; i<allEntries.size();i++)
        {
           if(allEntries.get(i).getId().equalsIgnoreCase(id)&&
              allEntries.get(i).getFirstName().equalsIgnoreCase("Pavel")&&
              allEntries.get(i).getLastName().equalsIgnoreCase("Bragin")&&
              allEntries.get(i).getPhoneNumber().equalsIgnoreCase("+79811706016")&&
              allEntries.get(i).getAdditionalInformation().equalsIgnoreCase("test19191919"))
           {
               this.contactsEntityDao.delete(id);
               return;
           }
        }
        fail("Cant save contact");
    }
    
    @Test
    public void testFind() {
        boolean foundContact=false;
        System.out.println("Find");
        ContactsEntity entity = new ContactsEntity("Pavel", "Bragin", "+79811706016", "test19191919");
        String id = this.contactsEntityDao.save(entity);
        ContactsEntity foundEntity = this.contactsEntityDao.find(id);
        System.out.println(foundEntity);
        if(foundEntity.getId().equalsIgnoreCase(id))
        {
            foundContact = true;
            this.contactsEntityDao.delete(id);
        }
        if(!foundContact)
            fail("Cant find contact");
    }
    
    @Test
    public void testDelete() {
        boolean foundContact=false;
        ContactsEntity entity = new ContactsEntity("Pavel", "Bragin", "+79811706016", "test19191919");
        this.contactsEntityDao.save(entity);
        List<ContactsEntity> allEntries = this.contactsEntityDao.findAll();
        for(int i =0; i<allEntries.size();i++)
        {
           if(
              allEntries.get(i).getFirstName().equalsIgnoreCase("Pavel")&&
              allEntries.get(i).getLastName().equalsIgnoreCase("Bragin")&&
              allEntries.get(i).getPhoneNumber().equalsIgnoreCase("+79811706016")&&
              allEntries.get(i).getAdditionalInformation().equalsIgnoreCase("test19191919"))
           {
               foundContact = true;
               this.contactsEntityDao.delete(allEntries.get(i).getId());
           }
        }
        if(foundContact)
        {
            allEntries = this.contactsEntityDao.findAll();
            for(int i =0; i<allEntries.size();i++)
            {
                if(
                    allEntries.get(i).getFirstName().equalsIgnoreCase("Pavel")&&
                    allEntries.get(i).getLastName().equalsIgnoreCase("Bragin")&&
                    allEntries.get(i).getPhoneNumber().equalsIgnoreCase("+79811706016")&&
                    allEntries.get(i).getAdditionalInformation().equalsIgnoreCase("test19191919"))
                {
                    fail("Cant delete contact");
                }
            }
        }
    }
}
