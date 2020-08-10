package jcorreia.luxclusif.challenge.webapp_challenge.controllers;

import jcorreia.luxclusif.challenge.webapp_challenge.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping("/items")
    public String getItems(Model model){

        model.addAttribute("items", itemRepository.findAll());

        return "items/list";
    }
}
