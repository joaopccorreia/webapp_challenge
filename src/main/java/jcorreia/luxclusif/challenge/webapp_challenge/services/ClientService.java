package jcorreia.luxclusif.challenge.webapp_challenge.services;

import jcorreia.luxclusif.challenge.webapp_challenge.model.Client;

import java.util.List;

public interface ClientService {

    public Client findByClientName(String clientName);

    public Client saveOrUpdate(Client client);

    public void delete(String clientName);
}
