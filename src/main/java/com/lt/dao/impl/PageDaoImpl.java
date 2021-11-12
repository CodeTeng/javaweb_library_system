package com.lt.dao.impl;

import com.lt.dao.PageDao;
import com.lt.domain.Book;
import com.lt.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: lt
 * Date: 2021/10/19 - 9:41
 **/
public class PageDaoImpl implements PageDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化
        String sql = "select count(*) from book where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keyset = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keyset) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " +key+ " like ? ");
                params.add("%"+value+"%");  //?条件的值
            }
        }

        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<Book> findByPage(int start, int rows, Map<String, String[]> condition) {
        //1.定义模板初始化
        String sql = "select * from book where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keyset = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keyset) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");  //?条件的值
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);

        return template.query(sb.toString(), new BeanPropertyRowMapper<Book>(Book.class), params.toArray());
    }
}
