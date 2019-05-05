package com.smlyk.orm.demo.dao;

import com.smlyk.orm.demo.entity.User;
import com.smlyk.orm.framework.BaseDaoSupport;
import com.smlyk.orm.framework.QueryRule;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author yekai
 */
@Repository
public class UserDao extends BaseDaoSupport<User, Integer>{


    @Override
    protected String getPKColumn() {
        return "id";
    }

    @Override
    @Resource(name = "dataSource")
    protected void setDataSource(DataSource dataSource) {
        super.setDataSourceReadOnly(dataSource);
        super.setDataSourceWrite(dataSource);
    }

    public List<User> selectAll() throws Exception{
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.andLike("name", "%云%");
        return super.select(queryRule);
    }
}
