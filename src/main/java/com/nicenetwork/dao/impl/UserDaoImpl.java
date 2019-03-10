package com.nicenetwork.dao.impl;

import com.nicenetwork.dao.UserDao;
import com.nicenetwork.model.Profile;
import com.nicenetwork.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static sun.security.krb5.Confounder.intValue;

/**
 * Created by gsp on 15/07/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    private static final int limitItemPerpage = 5;

    @Override
    public List<User> getData(int page, String searchKeyword) {

        Query query;
        if (searchKeyword.equals("")) {
            String hql = "from User as user join fetch user.profile";
            query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setMaxResults(limitItemPerpage);
            query.setFirstResult(page * limitItemPerpage);
        } else {
            String hql = "from User as user inner join fetch user.profile where username LIKE '%" + searchKeyword + "%'";
            query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setMaxResults(limitItemPerpage);
            query.setFirstResult(page * limitItemPerpage);
        }

        return query.list();
    }

    @Override
    public User getDataByName(String searchKeyword) {
        Query query= sessionFactory.getCurrentSession().
                createQuery("from User where username=:param");
        query.setParameter("param", searchKeyword);
        User param = (User) query.uniqueResult();

        return param;

    }

    @Override
    public User getData(Integer id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public User edit(User user) {
        sessionFactory.getCurrentSession().update(user);
        return user;
    }


    @Override
    public User delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
        return user;
    }

    @Override
    public int getMaxCount(String searchKeyword) {
        String hql = "select count(*) from User as user inner join user.profile where username LIKE '%" + searchKeyword + "%'";
        int count = ((Long) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult()).intValue();
        return count;
    }

}
