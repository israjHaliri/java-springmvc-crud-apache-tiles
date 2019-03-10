package com.nicenetwork.dao.impl;

import com.nicenetwork.dao.ProfileDao;
import com.nicenetwork.dao.UserDao;
import com.nicenetwork.model.Profile;
import com.nicenetwork.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gsp on 15/07/2016.
 */
@Repository
public class ProfileDaoImpl implements ProfileDao{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public Profile getData(Integer id) {

        Query query= sessionFactory.getCurrentSession().
                createQuery("from Profile where user_id=:user_id");
        query.setParameter("user_id", id);
        Profile param = (Profile) query.uniqueResult();

        return (Profile) sessionFactory.getCurrentSession().get(Profile.class, param.getId());
    }
}
