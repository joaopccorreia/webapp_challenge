package jcorreia.luxclusif.challenge.webapp_challenge.controllers;

import jcorreia.luxclusif.challenge.webapp_challenge.dto.ItemDto;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.ItemDtoToItem;
import jcorreia.luxclusif.challenge.webapp_challenge.dto.converters.ItemToItemDto;
import jcorreia.luxclusif.challenge.webapp_challenge.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;
    private ItemDtoToItem itemDtoToItem;
    private ItemToItemDto itemToItemDto;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    public void setItemDtoToItem(ItemDtoToItem itemDtoToItem) {
        this.itemDtoToItem = itemDtoToItem;
    }

    @Autowired
    public void setItemToItemDto(ItemToItemDto itemToItemDto) {
        this.itemToItemDto = itemToItemDto;
    }

    @PostMapping("/{id}/add/")
    public String addItem(@PathVariable Integer id, ItemDto itemDto) {
        itemService.add(itemDtoToItem.convert(itemDto));
        return "redirect:/formPage";
    }

    @GetMapping("/item")
    public String listAllItems(Model model) {
        System.out.println(model.addAttribute("items", itemToItemDto.convert(itemService.listOfItems())));

        return "homePage";
    }
}
