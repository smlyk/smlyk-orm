package com.smlyk.orm.test;

import com.smlyk.orm.demo.dao.UserDao;
import com.smlyk.orm.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author yekai
 */
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrmTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectAllForUser(){

        try {
            List<User> userList = userDao.selectAll();
            System.out.println(Arrays.toString(userList.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
