package jcorreia.luxclusif.challenge.webapp_challenge.dto.converters;

import jcorreia.luxclusif.challenge.webapp_challenge.dto.ClientDto;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientDto extends AbstractConverter<Client, ClientDto> {

    @Override
    public ClientDto convert(Client client) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(client, ClientDto.class);
    }
}
