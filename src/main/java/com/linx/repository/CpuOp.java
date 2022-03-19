package com.linx.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @title: CpuOp
 * @Author yqliu
 * @Date: 2022/3/17 下午8:09
 * @Version 1.0
 */
public class CpuOp {
    public Object getCpuInfo() throws SQLException {
        DB dt = new DB();
        String sql = "select * from node_managers order by created_at desc limit 1";
        PreparedStatement stmt = dt.InitDao().prepareStatement(sql);
        Object rs = stmt.executeQuery();
        return rs;
    }
}
