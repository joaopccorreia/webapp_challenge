package jcorreia.luxclusif.challenge.webapp_challenge.services;

import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;

public interface ItemService {

    Item get(Integer id);

    Item add(Item item);

    Item edit(Item item);
}
