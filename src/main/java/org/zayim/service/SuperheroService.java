package org.zayim.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zayim.model.Superhero;

import java.util.List;

@Service
@Transactional
public class SuperheroService {

    @Autowired
    private SessionFactory sessionFactory;

    public Superhero save(Superhero superhero) {
        sessionFactory.getCurrentSession().save(superhero);
        return superhero;
    }

    public List<Superhero> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Superhero s").list();
    }

    public Superhero findById(Integer id) {
        return sessionFactory.getCurrentSession().get(Superhero.class, id);
    }
}
