package jcorreia.luxclusif.challenge.webapp_challenge.dto.converters;

import jcorreia.luxclusif.challenge.webapp_challenge.dto.UserDto;
import jcorreia.luxclusif.challenge.webapp_challenge.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser extends AbstractConverter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDto, User.class);
    }
}
