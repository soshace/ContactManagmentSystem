package contactMS.dao;

import java.util.List;

import contactMS.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.transaction.annotation.Transactional;

public class JpaDao<T extends Entity> implements Dao<T> {

    @Autowired
    private MongoOperations mongoOperations;

    protected Class<T> entityClass;

    public JpaDao() {
    }

    public JpaDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return mongoOperations.findAll(this.entityClass);
    }

    @Override
    @Transactional(readOnly = true)
    public T find(String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), this.entityClass);
    }

    @Override
    @Transactional
    public void delete(String id) {
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
