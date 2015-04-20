package contactMS.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.util.List;

import contactMS.entity.Entity;
import contactMS.entity.User;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

public class JpaDao<T extends Entity, I> implements Dao<T, I>
{
        @Autowired private MongoOperations mongoOperations;

	protected Class<T> entityClass;

        public JpaDao()
        {
        }
        
	public JpaDao(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll()
	{
		return mongoOperations.findAll(this.entityClass);
	}


	@Override
	@Transactional(readOnly = true)
	public T find(I id)
	{
                return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), this.entityClass);
	}


        @Override
	@Transactional
	public T save(T entity)
	{
            mongoOperations.save(entity);
            return entity;
	}


	@Override
	@Transactional
	public void delete(I id)
	{
		if (id == null) {
			return;
		}

		T entity = this.find(id);
		if (entity == null) {
			return;
		}

		mongoOperations.remove(Query.query(Criteria.where("id").is(id)), this.entityClass);
	}

}