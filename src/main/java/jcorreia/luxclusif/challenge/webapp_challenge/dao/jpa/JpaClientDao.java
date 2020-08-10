package jcorreia.luxclusif.challenge.webapp_challenge.dao.jpa;

import jcorreia.luxclusif.challenge.webapp_challenge.dao.ClientDao;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Client;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaClientDao extends JpaGenericDao<Client> implements ClientDao {

    public JpaClientDao() {
        super(Client.class);
    }

    public List<Item> findByClientName(Integer clientId) {
        return entityManager.createQuery("from client_item where client_id =" + clientId).getResultList();
    }
}
