package com.nicenetwork.service;

import com.nicenetwork.model.LandingPage;
import com.nicenetwork.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gsp on 15/07/2016.
 */
public interface LandingPageService {

    public List<LandingPage> getData(int startrow,int total,String searchKeyword);
    public LandingPage getDataById(int id);
    public void saveOrUpdate(LandingPage landingPage);
    public int getCount(String searchKeyword);

}
