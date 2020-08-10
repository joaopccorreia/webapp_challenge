package jcorreia.luxclusif.challenge.webapp_challenge.repositories;

import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
