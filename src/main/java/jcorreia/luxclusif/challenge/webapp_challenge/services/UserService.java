package jcorreia.luxclusif.challenge.webapp_challenge.services;

import jcorreia.luxclusif.challenge.webapp_challenge.model.User;

public interface UserService {

    User findByUserName(String userName);

    User saveOrUpdate(User user);
}
