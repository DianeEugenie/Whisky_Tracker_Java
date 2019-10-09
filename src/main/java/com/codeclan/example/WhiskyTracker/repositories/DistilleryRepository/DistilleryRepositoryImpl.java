package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> getDistilleriesFromRegion(String region) {

        List<Distillery> foundDistilleries = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("region", region));

            foundDistilleries = cr.list();
        } catch(HibernateException e) {
            e.printStackTrace();
        }

        return foundDistilleries;
    }

    @Transactional
    public List<Distillery> getDistilleriesWithWhiskiesOfAge(int age) {

        List<Distillery> foundDistilleries = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whisky");
            cr.add(Restrictions.eq("whisky.age", age));

            foundDistilleries = cr.list();
        } catch(HibernateException e) {
            e.printStackTrace();
        }

        return foundDistilleries;
    }
}
