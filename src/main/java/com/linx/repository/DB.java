package com.linx.repository;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @title: DB
 * @Author yqliu
 * @Date: 2022/3/17 下午8:08
 * @Version 1.0
 */
public class DB {
//    @Value("${spring.datasource.url}")
//    private static String CONNECTION;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private static String dbClassName;
//
//    @Value("${spring.datasource.username}")
//    private static String username;
//
//    @Value("${spring.datasource.password}")
//    private static String password;

    // todo 数据库的连接ip 需要进行文件指定
    private static final String CONNECTION = "jdbc:mariadb://172.30.25.34:3306/lxdmanager";
    private static final String dbClassName = "org.mariadb.jdbc.Driver";

    // 初始化连接mariadb client
    public static Connection InitDao() {
//        System.out.println(dbClassName);
        // TODO 解决从appclication.properties中读取配置信息
        // Class.forName(xxx) loads the jdbc classes and
        // creates a drivermanager class factory
        try {
            Class.forName(dbClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Properties for user and password. Here the user and password are both 'paulr'
        Properties p = new Properties();
        p.put("user", "root");
        p.put("password", "root");
//         Now try to connect
        Connection c = null;
        try {
//            c = DriverManager.getConnection(CONNECTION, username, password);
            c = DriverManager.getConnection(CONNECTION, p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println("Connect to mariadb success!");
        // 尝试连接成功之后，进行dao client的返回
        return c;
    }
}
