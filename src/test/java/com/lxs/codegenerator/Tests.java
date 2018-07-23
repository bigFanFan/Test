package com.lxs.codegenerator;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.SqlRunner;
import sun.applet.Main;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Limiaojun
 * @create: 2018-06-28 14:53
 **/
public class Tests {

    public static void main(String[] args) {
        SqlRunner runner = SqlRunner.create();
        List<Entity> all;
        Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);
        {
            try {
                all = runner.page(Entity.create("product").set("group_id","> 20"), new Page(1, 5));
                all.forEach(a->System.out.println(a));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
