package com.nicenetwork.service.impl;

import com.nicenetwork.dao.ProfileDao;
import com.nicenetwork.dao.UserDao;
import com.nicenetwork.model.Profile;
import com.nicenetwork.model.User;
import com.nicenetwork.service.ProfileService;
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
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileDao profileDao;

    @Override
    public Profile getData(Integer id) {
        return profileDao.getData(id);
    }

}
