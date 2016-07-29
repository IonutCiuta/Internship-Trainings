package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by iciuta on 7/28/2016.
 */
public class PersistenceHandler {
    private static EntityManager entityManager;

    private PersistenceHandler() {}

    public static void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("web-jsp");
        entityManager = emf.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
