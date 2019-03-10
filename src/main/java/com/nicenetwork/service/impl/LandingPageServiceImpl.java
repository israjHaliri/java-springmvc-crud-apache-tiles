package com.nicenetwork.service.impl;

import com.nicenetwork.dao.LandingPageDao;
import com.nicenetwork.dao.UserDao;
import com.nicenetwork.model.LandingPage;
import com.nicenetwork.model.User;
import com.nicenetwork.service.LandingPageService;
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
public class LandingPageServiceImpl implements LandingPageService{

    @Autowired
    LandingPageDao landingPageDao;

    @Override
    public List<LandingPage> getData(int startrow,int total,String searchKeyword) {
        return landingPageDao.getData(startrow,total,searchKeyword);
    }

    @Override
    public LandingPage getDataById(int id){
        return landingPageDao.getDataById(id);
    }

    @Override
    public void saveOrUpdate(LandingPage landingPage){
        landingPageDao.saveOrUpdate(landingPage);
    }

    @Override
    public int getCount(String searchKeyword) {
        return landingPageDao.getCount(searchKeyword);
    }


}
