package jcorreia.luxclusif.challenge.webapp_challenge.services;


import jcorreia.luxclusif.challenge.webapp_challenge.dao.jpa.JpaClientDao;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Client;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private JpaClientDao jpaClientDao;

    public void setJpaClientDao(JpaClientDao jpaClientDao) {
        this.jpaClientDao = jpaClientDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Client get(Integer id) {
        return jpaClientDao.findById(id);
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return jpaClientDao.saveOrUpdate(client);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        jpaClientDao.delete(id);
    }

    @Override
    @Transactional (readOnly = true)
    public List<Client> list() {
        return jpaClientDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> listofItems(Integer id) {
        return jpaClientDao.findItem(id);
    }
}
