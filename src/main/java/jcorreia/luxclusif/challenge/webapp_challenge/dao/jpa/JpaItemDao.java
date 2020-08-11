package jcorreia.luxclusif.challenge.webapp_challenge.dao.jpa;

import jcorreia.luxclusif.challenge.webapp_challenge.dao.ItemDao;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaItemDao extends JpaGenericDao<Item> implements ItemDao {

    public JpaItemDao() {
        super(Item.class);
    }

    public List<Item> findAll() {
        return entityManager.createQuery("from " + modelType.getSimpleName() + "where isActive = 1", modelType).getResultList();
    }
}
