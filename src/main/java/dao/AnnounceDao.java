package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.entities.Announce;

/**
 *
 * @author 31409695
 */
public class AnnounceDao extends Dao<Announce> {

    public AnnounceDao() {
        super();
    }

    public Announce findById(String id) {
        openConnection();
        Announce announce = new Announce();

        announce = entityManager.find(Announce.class, id);
        entityManager.close();

        return announce;
    }

    public List<Announce> findAll() {
        openConnection();
        List<Announce> announces = new ArrayList<>();

        Query query = entityManager.createNamedQuery("Annouce.findAll");
        announces = query.getResultList();

        entityManager.close();

        return announces;

    }

    public void save(Announce e) {
        openConnection();

        entityManager.persist(e);

        entityManager.close();
    }

    public boolean delete(Announce e) {
        openConnection();

        try {
            Announce announce = entityManager.merge(e);
            entityManager.remove(announce);
            entityManager.flush();
            entityManager.close();
        } catch (RuntimeException ex) {
            return false;
        }
        return true;
    }

    public void openConnection() {
        entityManager = entityManagerFactory.createEntityManager();
    }

}
