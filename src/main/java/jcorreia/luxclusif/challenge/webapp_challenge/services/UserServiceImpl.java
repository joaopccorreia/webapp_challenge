package jcorreia.luxclusif.challenge.webapp_challenge.services;

import jcorreia.luxclusif.challenge.webapp_challenge.dao.jpa.JpaUserDao;
import jcorreia.luxclusif.challenge.webapp_challenge.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private JpaUserDao jpaUserDao;

    @Autowired
    public void setJpaUserDao(JpaUserDao jpaUserDao) {
        this.jpaUserDao = jpaUserDao;
    }

    @Transactional
    public User findByUserName(String userName) {
        return jpaUserDao.findByUserName(userName);
    }

    @Transactional
    public User saveOrUpdate(User user) {
        return jpaUserDao.saveOrUpdate(user);
    }
}
