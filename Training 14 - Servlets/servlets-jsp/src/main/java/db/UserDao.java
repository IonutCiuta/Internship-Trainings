package db;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by iciuta on 7/29/2016.
 */
public class UserDao {
    private static EntityManager entityManager;

    static {
        entityManager = PersistenceHandler.getEntityManager();
    }

    public static void insert(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public static User findUserById(Long id) {
        User result;

        entityManager.getTransaction().begin();
        result = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();

        return result;
    }

    public static User findUserByName(String username) {
        User result;

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username LIKE :username");
        query.setParameter("username", username);
        result = (User) query.getSingleResult();
        entityManager.getTransaction().commit();

        return result;
    }
}
