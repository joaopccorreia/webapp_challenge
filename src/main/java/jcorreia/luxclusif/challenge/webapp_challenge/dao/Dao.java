package jcorreia.luxclusif.challenge.webapp_challenge.dao;

import jcorreia.luxclusif.challenge.webapp_challenge.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);
}
