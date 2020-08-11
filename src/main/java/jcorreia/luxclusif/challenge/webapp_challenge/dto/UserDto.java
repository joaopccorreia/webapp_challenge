package jcorreia.luxclusif.challenge.webapp_challenge.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Component
public class UserDto {

    private Integer clientId;

    private String userName;

    @NotNull
    private String password;
}
