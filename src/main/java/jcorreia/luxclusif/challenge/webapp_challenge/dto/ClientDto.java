package jcorreia.luxclusif.challenge.webapp_challenge.dto;

import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Component
public class ClientDto {

    @NotNull
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String vatNumber;

    @NotNull
    private String email;

    @NotNull
    private String age;

    @NotNull
    private String phone;

    private List<Item> listOfItems;

    public List<Item> getListOfItems() {
        return listOfItems;
    }
}
