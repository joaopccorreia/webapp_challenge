package jcorreia.luxclusif.challenge.webapp_challenge.services;

import jcorreia.luxclusif.challenge.webapp_challenge.dao.ItemDao;
import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao;

    @Autowired
    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Item get(Integer id) {
        return itemDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> listOfItems() {
        return itemDao.findAll();
    }

    @Override
    @Transactional
    public Item add(Item item) {
        return itemDao.saveOrUpdate(item);
    }

    @Override
    @Transactional
    public Boolean remove(Item item) {
        itemDao.delete(item.getId());
        return get(item.getId()) == null;
    }

    @Override
    @Transactional
    public Item edit(Item item) {
        return itemDao.saveOrUpdate(item);
    }
}
