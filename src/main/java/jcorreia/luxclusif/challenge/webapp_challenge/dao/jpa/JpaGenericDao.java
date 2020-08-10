package jcorreia.luxclusif.challenge.webapp_challenge.dao.jpa;

import jcorreia.luxclusif.challenge.webapp_challenge.dao.Dao;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class JpaGenericDao<T extends Model> implements Dao<T> {

    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<T> modelType;

    public JpaGenericDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from" + modelType.getSimpleName(), modelType).getResultList();
    }

    @Override
    public T findById(Integer id) {
        return entityManager.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return entityManager.merge(modelObject);
    }
}
