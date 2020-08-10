package jcorreia.luxclusif.challenge.webapp_challenge.services;

import jcorreia.luxclusif.challenge.webapp_challenge.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private JpaClientDao jpaClientDao;

    @Autowired
    public void setJpaClientDao(JpaClientDao jpaClientDao) {
        this.jpaClientDao = jpaClientDao;
    }

    @Override
    public Client findByClientName(String clientName) {
        return jpaClientDao.findByClientName(clientName);
    }

    @Override
    public Client saveOrUpdate(Client client) {
        return jpaClientDao.saveOrUpdate(client);
    }

    @Override
    public void delete(String clientName) {

        jpaClientDao.delete(clientName);
    }
}
