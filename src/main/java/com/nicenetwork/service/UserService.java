package com.nicenetwork.service;

import com.nicenetwork.model.User;

import java.util.List;

/**
 * Created by gsp on 15/07/2016.
 */
public interface UserService {
    public List<User> getData(int page, String searchKeyword);
    public User getData(Integer id);
    public User getDataByName(String searchKeyword);
    public User save(User user);
    public User edit(User user);
    public User delete(User user);
    public int getMaxCount(String searchKeyword);
}
