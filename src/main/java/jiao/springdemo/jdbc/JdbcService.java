package jiao.springdemo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：wangbaojiao
 * @date ：Created in 6/17/2020 10:18 AM
 * @description：
 * @modified By：
 * @version: $
 */
@Service("jdbcService")
public class JdbcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String selectData() {
        String sql = " select count(*) from user ";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return "success";
    }

    @Transactional
    public void insertData() {
        String sql = " INSERT INTO `user`(name, create_time, update_time) VALUES(?,?,?) ";
        Date date = new Date();
        jdbcTemplate.update(sql, new Object[]{"testtest222", date, date});
        throw new RuntimeException("throw runtime exception --- ");
    }

    public void insertDataNoTransactional() {
        String sql = " INSERT INTO `user`(name, create_time, update_time) VALUES(?,?,?) ";
        Date date = new Date();
        jdbcTemplate.update(sql, new Object[]{"testtest222", date, date});
        throw new RuntimeException("throw runtime exception --- ");
    }


}
