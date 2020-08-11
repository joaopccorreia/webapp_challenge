package jcorreia.luxclusif.challenge.webapp_challenge.services;

import jcorreia.luxclusif.challenge.webapp_challenge.model.Client;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;

import java.util.List;

public interface ClientService {

    Client get(Integer id);

    Client save(Client client);

    void delete(Integer id);

    List<Client> list();

    List<Item> listofItems(Integer id);
}
