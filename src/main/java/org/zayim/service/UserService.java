package org.zayim.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zayim.model.User;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private SessionFactory sessionFactory;

    public User findByUsername(String username) {

        Query query = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.username=:username").setString("username", username);
        List<User> list = query.list();
        return list.isEmpty() ? null : list.get(0);
    }
}
