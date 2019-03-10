package com.nicenetwork.service.impl;

import com.nicenetwork.dao.FileDao;
import com.nicenetwork.dao.LandingPageDao;
import com.nicenetwork.model.File;
import com.nicenetwork.model.LandingPage;
import com.nicenetwork.service.FileService;
import com.nicenetwork.service.LandingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gsp on 15/07/2016.
 */
@Service
@Transactional
public class FileServiceImpl implements FileService{

    @Autowired
    FileDao fileDao;

    @Override
    public List<File> getData(int startrow, int total, String searchKeyword, int id) {
        return fileDao.getData(startrow,total,searchKeyword,id);
    }

    @Override
    public File getDataById(int id)  {
        return fileDao.getDataById(id);
    }

    @Override
    public void save(File file){
        fileDao.save(file);
    }

    @Override
    public void delete(int id){
        fileDao.delete(id);
    }

    @Override
    public int getCount(String searchKeyword,int id) {
        return fileDao.getCount(searchKeyword, id);
    }


}
