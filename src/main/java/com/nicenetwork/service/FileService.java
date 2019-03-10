package com.nicenetwork.service;

import com.nicenetwork.model.File;
import com.nicenetwork.model.LandingPage;

import java.util.List;

/**
 * Created by gsp on 15/07/2016.
 */
public interface FileService {

    public List<File> getData(int startrow, int total, String searchKeyword, int id);

    public File getDataById(int id);

    public void save(File file) ;

    public void delete(int id);

    public int getCount(String searchKeyword,int id);

}
