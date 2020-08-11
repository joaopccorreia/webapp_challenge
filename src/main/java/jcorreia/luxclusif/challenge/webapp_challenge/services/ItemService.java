package jcorreia.luxclusif.challenge.webapp_challenge.services;

import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;

import java.util.List;

public interface ItemService {

    Item get(Integer id);

    List<Item> listOfItems();

    Item add(Item item);

    Boolean remove(Item item);

    Item edit(Item item);
}
