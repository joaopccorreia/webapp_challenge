package jcorreia.luxclusif.challenge.webapp_challenge.dto.converters;

import jcorreia.luxclusif.challenge.webapp_challenge.dto.UserDto;
import jcorreia.luxclusif.challenge.webapp_challenge.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto extends AbstractConverter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDto.class);
    }
}
