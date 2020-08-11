package jcorreia.luxclusif.challenge.webapp_challenge.dao.jpa;

import jcorreia.luxclusif.challenge.webapp_challenge.dao.UserDao;
import jcorreia.luxclusif.challenge.webapp_challenge.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaUserDao implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    public User saveOrUpdate(User user) {
        return entityManager.merge(user);
    }
}
