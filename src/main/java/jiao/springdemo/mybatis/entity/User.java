package jiao.springdemo.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ：wangbaojiao
 * @date ：Created in 6/17/2020 10:31 AM
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class User implements Serializable{

    public Long id;

    public String name;

    public LocalDateTime createTime;

    public LocalDateTime updateTime;

}
