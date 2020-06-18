package jiao.springdemo;

import jiao.springdemo.mybatis.entity.User;
import jiao.springdemo.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：wangbaojiao
 * @date ：Created in 6/16/2020 1:41 PM
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@RestController
@Slf4j
public class Application implements CommandLineRunner {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate testJdbcTemplate;

    @Autowired
    private TestService testService;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("testJdbcTemplate")
    public Map<String, Object> testJdbcTemplate() {
        Map<String, Object> stringObjectMap = testJdbcTemplate.queryForMap(" SELECT u.id, u.name, u.create_time, u.update_time from user u;");
        return stringObjectMap;
    }

    @RequestMapping("testTransactional")
    public String testTransactional() {
        testService.insertData();
        return "success";
    }

    @RequestMapping("noTransactional")
    public String noTransactional() {
        testService.insertDataNoTransactional();
        return "success";
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
//        showData();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        log.info(log.getClass().toString());
        conn.close();
    }

    @RequestMapping("batchInsert")
    public String batchInsert() throws SQLException {
        String sql = " INSERT INTO `user`(name, create_time, update_time)\n" +
                "VALUES(?,?,?) ";
        Date date = new Date();
        for (int i = 0; i < 100; i++) {
            List<Object[]> list = new ArrayList<>(10000);
            for (int j = 0; j < 10000; j++) {
                list.add(new Object[]{"test" + j, date, date});
            }
            long startTime = System.currentTimeMillis();
//            testJdbcTemplate.batchUpdate(sql, list);
            System.out.println("--1000条数据花费时间-" + (System.currentTimeMillis() - startTime) + "毫秒");
        }
        return "success";
    }


    @RequestMapping("testmybatis")
    public Object testMybatis() throws SQLException {
        List<User> userList = userService.getUserList();
        return userList;
    }

}
