package jcorreia.luxclusif.challenge.webapp_challenge.bootstrap;

import jcorreia.luxclusif.challenge.webapp_challenge.domain.Client;
import jcorreia.luxclusif.challenge.webapp_challenge.domain.Item;
import jcorreia.luxclusif.challenge.webapp_challenge.repositories.ClientRepository;
import jcorreia.luxclusif.challenge.webapp_challenge.repositories.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ItemRepository itemRepository;

    public BootStrapData(ClientRepository clientRepository, ItemRepository itemRepository) {
        this.clientRepository = clientRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Client joao = new Client("João", "Correia", 32);
        Item bag = new Item("Bag", "Gucci");
        joao.getItems().add(bag);
        bag.getClient().add(joao);

        clientRepository.save(joao);
        itemRepository.save(bag);

        Client carol = new Client("Carolina", "Silva", 27);
        Item backpack = new Item("Backpack", "Louis Vitton");
        carol.getItems().add(backpack);
        backpack.getClient().add(carol);

        clientRepository.save(carol);
        itemRepository.save(backpack);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + itemRepository.count());
    }
}
