package com.nicenetwork.dao.impl;

import com.nicenetwork.dao.FileDao;
import com.nicenetwork.dao.LandingPageDao;
import com.nicenetwork.model.File;
import com.nicenetwork.model.LandingPage;
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
public class FileDaoImpl implements FileDao {

    private JdbcTemplate jdbcTemplate;

    public FileDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<File> getData(int startrow, int total, String searchKeyword, int id) {
        String sql = "";
        if (searchKeyword.equalsIgnoreCase("")) {
            sql = "SELECT * FROM file where parent_id = " + id + " limit " + startrow + "," + total;
        } else {
            sql = "SELECT * FROM file where name LIKE '%" + searchKeyword + "%' and parent_id = " + id + "  limit " + startrow + "," + total;
        }

        List<File> listParam = jdbcTemplate.query(sql, new RowMapper<File>() {

            @Override
            public File mapRow(ResultSet rs, int rowNum) throws SQLException {
                File param = new File();
                param.setId(rs.getInt("id"));
                param.setFile(rs.getString("file"));
                param.setName(rs.getString("name"));
                param.setParent_id(rs.getInt("parent_id"));

                return param;
            }

        });

        System.out.println("list apram dao ="+sql);
        return listParam;
    }

    @Override
    public File getDataById(int id) {
        String sql = "SELECT * FROM file WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<File>() {

            @Override
            public File extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    File param = new File();
                    param.setName(rs.getString("name"));
                    param.setFile(rs.getString("file"));
                    param.setParent_id(rs.getInt("parent_id"));
                    return param;
                }

                return null;
            }

        });
    }

    @Override
    public void save(File file) {
        System.out.println("file.getParent_id() = "+file.getParent_id());
        String sql = "INSERT file SET file=?, name=?, parent_id=?";
        jdbcTemplate.update(sql, file.getFile(), file.getName(), file.getParent_id());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM file WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public int getCount(String searchKeyword,int id) {
        String sql = "SELECT COUNT(*) FROM file where name LIKE '%" + searchKeyword + "%' and parent_id = " + id;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
