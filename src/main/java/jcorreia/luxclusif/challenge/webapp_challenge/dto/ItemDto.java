package jcorreia.luxclusif.challenge.webapp_challenge.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Component
public class ItemDto {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String brand;
}
