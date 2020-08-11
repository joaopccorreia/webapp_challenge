package jcorreia.luxclusif.challenge.webapp_challenge.dto.converters;

import jcorreia.luxclusif.challenge.webapp_challenge.dto.ClientDto;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Client;
import jcorreia.luxclusif.challenge.webapp_challenge.services.ClientService;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoToClient extends AbstractConverter<ClientDto, Client> {

    private ClientService clientService;

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Client convert(ClientDto clientDto) {

        Client client = clientDto.getId() == null ?
                new Client() :
                clientService.get(clientDto.getId());

        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setVatNumber(clientDto.getVatNumber());
        client.setEmail(clientDto.getEmail());
        client.setAge(clientDto.getAge());
        client.setPhone(clientDto.getPhone());

        return client;
    }
}
