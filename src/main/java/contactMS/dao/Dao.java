package contactMS.dao;

import java.util.List;

import contactMS.entity.Entity;

public interface Dao<T extends Entity> {

    List<T> findAll();

    T find(String id);

    void delete(String id);
}
