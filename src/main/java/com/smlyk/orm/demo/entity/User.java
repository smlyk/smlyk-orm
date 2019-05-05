package com.smlyk.orm.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yekai
 */
@Entity
@Table(name = "user")
@Data
public class User implements Serializable{

    @Id
    private Integer id;

    private String name;

    private Integer age;

    private String addr;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
