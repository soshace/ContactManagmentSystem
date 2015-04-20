package contactMS.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Represent a contacts entity.
 */

@Document(collection = ContactsEntity.COLLECTION_NAME)
@XmlRootElement
public class ContactsEntity implements Entity
{       
        public static final String COLLECTION_NAME = "contacts";
	@Column
	private String id;

	@Column
	private String firstName;

	@Column
	private String lastName;

        @Column
	private String phoneNumber;
        
        @Column
	private String additionalInformation;


	public String getId()
	{
		return this.id;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String name)
	{
		this.firstName = name;
	}
 
	public String getLastName()
	{
		return this.lastName;
	}


	public void setLastName(String name)
	{
		this.lastName = name;
	}

        public String getPhoneNumber()
	{
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phone)
	{
		this.phoneNumber = phone;
	}

        public String getAdditionalInformation()
	{
		return this.phoneNumber;
	}

	public void setAdditionalInformation(String phone)
	{
		this.phoneNumber = phone;
	}

	@Override
	public String toString()
	{
		return String.format("ContactEntity[%s, %s, %s, %s, %s]", this.id, this.firstName, this.lastName, this.phoneNumber, this.additionalInformation);
	}

}