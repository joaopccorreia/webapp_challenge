package jcorreia.luxclusif.challenge.webapp_challenge.controllers;

import jcorreia.luxclusif.challenge.webapp_challenge.dto.ClientDto;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.UserDto;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.ClientDtoToClient;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.ClientToClientDto;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.UserDtoToUser;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.UserToUserDto;
import jcorreia.luxclusif.challenge.webapp_challenge.exception.AssociationExistantException;
import jcorreia.luxclusif.challenge.webapp_challenge.exception.ClientNotFoundException;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Client;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/add")
    public String addClient(Model model) {
        model.addAttribute("client", new ClientDto());
        model.addAttribute("user", new UserDto());
        return "signup";
    }

    @GetMapping("/{id}/edit/")
    public String editClient(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("client", clientToClientDto.convert(clientService.get(id)));
        return "edituser";
    }

    @GetMapping(path = "{id}/delete")
    public String deleteClient(@PathVariable Integer id, RedirectAttributes redirectAttributes)
            throws AssociationExistantException, ClientNotFoundException {
        Client client = clientService.get(id);
        clientService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted" + client.getFirstName() + " " + client.getLastName());
        return "homePage";
    }

}
