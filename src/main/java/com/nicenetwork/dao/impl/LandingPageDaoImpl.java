package com.nicenetwork.dao.impl;

import com.nicenetwork.dao.LandingPageDao;
import com.nicenetwork.dao.UserDao;
import com.nicenetwork.model.LandingPage;
import com.nicenetwork.model.Profile;
import com.nicenetwork.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gsp on 15/07/2016.
 */
@Repository
public class LandingPageDaoImpl implements LandingPageDao{

    private JdbcTemplate jdbcTemplate;

    public LandingPageDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<LandingPage> getData(int startrow,int total,String searchKeyword) {
        String sql = "";
        if (searchKeyword.equalsIgnoreCase(""))
        {
            sql = "SELECT * FROM landing_page limit "+startrow+","+total;
        }
        else
        {
            sql = "SELECT * FROM landing_page where title LIKE '%" + searchKeyword + "%' limit "+startrow+","+total;
        }

        List<LandingPage> listParam = jdbcTemplate.query(sql, new RowMapper<LandingPage>() {

            @Override
            public LandingPage mapRow(ResultSet rs, int rowNum) throws SQLException {
                LandingPage param = new LandingPage();
                param.setId(rs.getInt("id"));
                param.setTitle(rs.getString("title"));
                param.setSubtitle(rs.getString("subtitle"));
                param.setDescription(rs.getString("description"));
                param.setStatus(rs.getInt("status"));
                param.setCategory(rs.getInt("category"));
                param.setCreated_at(rs.getDate("created_at"));
                param.setUpdate_at(rs.getDate("update_at"));

                return param;
            }

        });

        System.out.println("sql ld pg ="+sql);
        return listParam;
    }

    @Override
    public LandingPage getDataById(int id) {
        String sql = "SELECT * FROM landing_page WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<LandingPage>() {

            @Override
            public LandingPage extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    LandingPage param = new LandingPage();
                    param.setId(rs.getInt("id"));
                    param.setTitle(rs.getString("title"));
                    param.setSubtitle(rs.getString("subtitle"));
                    param.setDescription(rs.getString("description"));
                    param.setStatus(rs.getInt("status"));
                    param.setCategory(rs.getInt("category"));
                    param.setCreated_at(rs.getDate("created_at"));
                    param.setUpdate_at(rs.getDate("update_at"));
                    return param;
                }

                return null;
            }

        });
    }


    @Override
    public void saveOrUpdate(LandingPage landingPage) {
        if (landingPage.getId() > 0) {
            // update
            System.out.println("ruuning update for "+ landingPage.getId());
            String sql = "UPDATE landing_page SET title=?, subtitle=?, description=?, "
                    + "status=?, category=?, created_at=?, update_at=? WHERE id=?";
            jdbcTemplate.update(sql, landingPage.getTitle(), landingPage.getSubtitle(),
                    landingPage.getDescription(), landingPage.getStatus(),landingPage.getCategory(),landingPage.getCreated_at(),landingPage.getUpdate_at(), landingPage.getId());
        } else {
            // insert
            String sql = "INSERT landing_page SET title=?, subtitle=?, description=?, "
                    + "status=?, category=?, created_at=?, update_at=?";
            jdbcTemplate.update(sql, landingPage.getTitle(), landingPage.getSubtitle(),
                    landingPage.getDescription(), landingPage.getStatus(),landingPage.getCategory(),landingPage.getCreated_at(),landingPage.getUpdate_at());
        }
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM landing_page WHERE id=?";
        String sqlFile = "DELETE FROM file WHERE parent_id=?";
        jdbcTemplate.update(sql, id);
        jdbcTemplate.update(sqlFile, id);
    }

    @Override
    public int getCount(String searchKeyword) {
        String sql = "SELECT COUNT(*) FROM landing_page where title LIKE '%" + searchKeyword + "%'";
//        String sql = "SELECT COUNT(*) FROM landing_page inner join file on file.parent_id=landing_page.id where title LIKE '%" + searchKeyword + "%'";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
