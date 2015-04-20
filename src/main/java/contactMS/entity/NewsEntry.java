package contactMS.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import contactMS.JsonViews;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * JPA Annotated Pojo that represents a contacts entry.
 */
@Document(collection = NewsEntry.COLLECTION_NAME)
public class NewsEntry implements Entity
{
        public static final String COLLECTION_NAME = "news";
	@Column
	private String id;

	@Column
	private Date date;

	@Column
	private String content;


	public NewsEntry()
	{
		this.date = new Date();
	}


	@JsonView(JsonViews.User.class)
	public String getId()
	{
		return this.id;
	}


	@JsonView(JsonViews.User.class)
	public Date getDate()
	{
		return this.date;
	}


	public void setDate(Date date)
	{
		this.date = date;
	}


	@JsonView(JsonViews.User.class)
	public String getContent()
	{
		return this.content;
	}


	public void setContent(String content)
	{
		this.content = content;
	}


	@Override
	public String toString()
	{
		return String.format("NewsEntry[%s, %s]", this.id, this.content);
	}

}