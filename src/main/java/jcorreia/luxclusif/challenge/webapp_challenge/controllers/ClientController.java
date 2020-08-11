package jcorreia.luxclusif.challenge.webapp_challenge.controllers;

import jcorreia.luxclusif.challenge.webapp_challenge.dto.ClientDto;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.ClientDtoToClient;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.ClientToClientDto;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.UserDtoToUser;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.UserToUserDto;
import jcorreia.luxclusif.challenge.webapp_challenge.services.ClientService;
import jcorreia.luxclusif.challenge.webapp_challenge.services.ItemService;
import jcorreia.luxclusif.challenge.webapp_challenge.services.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Setter
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;

    @Autowired
    private ClientToClientDto clientToClientDto;

    @Autowired
    private ClientDtoToClient clientDtoToClient;

    @Autowired
    private ItemService itemService;

    @GetMapping({"/", ""})
    public String getDashboard(Model model) {
        ClientDto clientDto = clientToClientDto.convert(clientService.get(1));
        model.addAttribute("items", clientDto.getListOfItems());
        model.addAttribute("client", clientDto);
        return "userdashboard";
    }

    @GetMapping("{id}")
    public String userDashboard(@PathVariable("id") Integer id, Model model) {
        ClientDto clientDto = clientToClientDto.convert(clientService.get(id));
        model.addAttribute("items", clientDto.getListOfItems());
        model.addAttribute("client", clientDto);
        return "userdashboard";
    }

}
