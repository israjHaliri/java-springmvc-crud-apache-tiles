package com.nicenetwork.dao;

        import com.nicenetwork.model.LandingPage;
        import com.nicenetwork.model.Profile;
        import com.nicenetwork.model.User;

        import java.util.List;

/**
 * Created by gsp on 15/07/2016.
 */
public interface LandingPageDao {

    public List<LandingPage> getData(int startrow,int total,String searchKeyword);

    public LandingPage getDataById(int id);

    public void saveOrUpdate(LandingPage landingPage);

    public void delete(int id);

    public int getCount(String searchKeyword);
}
