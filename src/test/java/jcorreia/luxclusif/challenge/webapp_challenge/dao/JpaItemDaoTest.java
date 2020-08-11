package jcorreia.luxclusif.challenge.webapp_challenge.dao;

import jcorreia.luxclusif.challenge.webapp_challenge.dao.jpa.JpaItemDao;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class JpaItemDaoTest {

    private static JpaItemDao jpaItemDao;
    private static EntityManager entityManager;

    @BeforeAll
    public static void setup() {
        entityManager = mock(EntityManager.class);

        jpaItemDao = new JpaItemDao();
        jpaItemDao.setEntityManager(entityManager);
    }

    @Test
    public void testFindAll() {
        List<Item> mockItem = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Item.class)).thenReturn(criteriaQuery);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(entityManager.createQuery(anyString(), any(Class.class))).thenReturn(typedQuery);
        when(entityManager.createQuery(any(CriteriaQuery.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockItem);

        List<Item> items = jpaItemDao.findAll();

        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockItem, items);

        System.out.println(items);
    }

    @Test
    public void testFindById() {
        int fakeId = 9999;
        Item fakeItem = new Item();
        when(entityManager.find(Item.class, fakeId)).thenReturn(fakeItem);

        Item item = jpaItemDao.findById(fakeId);

        verify(entityManager, times(1)).find(Item.class, fakeId);
        assertEquals(fakeItem, item);

        System.out.println(item);
    }

    @Test
    public void testSaveOrUpdate() {
        Item fakeItem = new Item();
        when(entityManager.merge(any(Item.class))).thenReturn(fakeItem);

        Item item = jpaItemDao.saveOrUpdate(fakeItem);

        verify(entityManager, times(1)).merge(any(Item.class));
        assertEquals(fakeItem, item);
    }

    @Test
    public void testDelete() {
        int fakeId = 9999;
        Item fakeItem = new Item();
        when(entityManager.find(Item.class, fakeId)).thenReturn(fakeItem);

        jpaItemDao.delete(fakeId);

        verify(entityManager, times(1)).remove(fakeItem);
    }

}
