package jiao.springdemo.mybatis.service;

import jiao.springdemo.mybatis.dao.UserDao;
import jiao.springdemo.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：wangbaojiao
 * @date ：Created in 6/17/2020 10:52 AM
 * @description：
 * @modified By：
 * @version: $
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;


    @Cacheable
    public List<User> getUserList() {
        return userDao.getUserList();
    }

}
