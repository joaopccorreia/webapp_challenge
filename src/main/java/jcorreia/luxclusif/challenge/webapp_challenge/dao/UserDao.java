package jcorreia.luxclusif.challenge.webapp_challenge.dao;

import jcorreia.luxclusif.challenge.webapp_challenge.model.User;

public interface UserDao {

    User findByUserName(String username);

    User saveOrUpdate(User user);
}
