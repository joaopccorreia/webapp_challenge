package jcorreia.luxclusif.challenge.webapp_challenge.services;

import jcorreia.luxclusif.challenge.webapp_challenge.dao.jpa.JpaItemDao;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ItemTest {

    private static ItemServiceImpl itemService;
    private static JpaItemDao jpaItemDao;

    @BeforeAll
    public static void setup() {
        jpaItemDao = mock(JpaItemDao.class);

        itemService = new ItemServiceImpl();
        itemService.setItemDao(jpaItemDao);
    }

    @Test
    public void itemFind() {
        int fakeId = 9999;
        Item fakeClient = new Item();
        when(jpaItemDao.findById(fakeId)).thenReturn(fakeClient);

        Item item = jpaItemDao.findById(fakeId);

        assertEquals(fakeClient, item);
    }

    @Test
    public void itemActive() {
        List<Item> fakeList = mock(ArrayList.class);
        when(jpaItemDao.findAll()).thenReturn(fakeList);

        List<Item> list = itemService.listOfItems();

        assertNotNull(list);
        verify(jpaItemDao, times(1)).findAll();
    }

    @Test
    public void itemAdd() {
        Item item = new Item();

        System.out.println(itemService.add(item));
    }

    @Test
    public void itemEdit() {
        Item item2 = new Item();

        System.out.println(itemService.edit(item2));
    }

    @Test
    public void itemRemove() {
        Item fakeItem = new Item();
        int fakeItemId = 9999;
        when(jpaItemDao.findById(fakeItemId)).thenReturn(fakeItem);

        itemService.remove(fakeItem);

        verify(jpaItemDao, times(1)).delete(fakeItem.getId());
    }
}
