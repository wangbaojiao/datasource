package jiao.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author ：wangbaojiao
 * @date ：Created in 6/16/2020 3:08 PM
 * @description：
 * @modified By：
 * @version: $
 */
@Service("testService")
public class TestService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
