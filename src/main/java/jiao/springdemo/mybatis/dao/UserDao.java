package jiao.springdemo.mybatis.dao;

import jiao.springdemo.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：wangbaojiao
 * @date ：Created in 6/17/2020 10:41 AM
 * @description：
 * @modified By：
 * @version: $
 */
@Mapper
public interface UserDao {

    public List<User> getUserList();
}
