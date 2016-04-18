package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Dao<E> {

    protected EntityManager entityManager;
    
    protected EntityManagerFactory entityManagerFactory;

    public Dao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("bookstore_pu");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    protected void openConnection() {
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    public abstract E findById(String id);

    public abstract List<E> findAll();

    public abstract void save(E e);

    public abstract boolean delete(E e);
}
