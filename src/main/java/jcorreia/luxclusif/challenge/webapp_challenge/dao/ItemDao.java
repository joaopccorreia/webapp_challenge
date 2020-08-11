package jcorreia.luxclusif.challenge.webapp_challenge.dao;

import jcorreia.luxclusif.challenge.webapp_challenge.model.Item;

import java.util.List;

public interface ItemDao extends Dao<Item> {

    List<Item> findAll();
}
