package com.nicenetwork.dao;

import com.nicenetwork.model.Profile;
import com.nicenetwork.model.User;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by gsp on 15/07/2016.
 */
public interface ProfileDao {
    public Profile getData(Integer id);
}
