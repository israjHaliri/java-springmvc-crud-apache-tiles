package com.nicenetwork.service.impl;

import com.nicenetwork.dao.UserDao;
import com.nicenetwork.model.User;
import com.nicenetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gsp on 15/07/2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getData(int page, String searchKeyword){
        return userDao.getData(page, searchKeyword);
    }

    @Override
    public User getData(Integer id) {
        return userDao.getData(id);
    }

    @Override
    public User getDataByName(String searchKeyword){
        return userDao.getDataByName(searchKeyword);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User edit(User user) {
        return userDao.edit(user);
    }

    @Override
    public User delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public int getMaxCount(String searchKeyword){
        return userDao.getMaxCount(searchKeyword);
    }

}
