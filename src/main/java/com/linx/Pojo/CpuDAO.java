package com.linx.Pojo;

import com.linx.repository.DB;

import java.sql.*;

/**
 * @title: CpuInfo
 * @Author yqliu
 * @Date: 2022/3/17 下午9:09
 * @Version 1.0
 */
public class CpuDAO {
    public Object getCpuInfo() throws SQLException {
        CpuInfo cpuInfo = new CpuInfo();
        String sql = "select * from node_managers order by created_at desc limit 1";
        Connection c = DB.InitDao();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int cpu = rs.getInt("cpu");
            String family = rs.getString("family");
            String model = rs.getString("model");
            double percent = rs.getDouble("percent");
            cpuInfo.CPU = cpu;
            cpuInfo.Family = family;
            cpuInfo.Model = model;
            cpuInfo.Percent = percent;
//            System.out.println("CPU: " + cpu);
//            System.out.println("family: " + family);
//            System.out.println("model: " + percent);
//            System.out.println(cpuInfo);
            rs.close();
            stmt.close();
            c.close();
            return cpuInfo;
        }
        rs.close();
        stmt.close();
        c.close();
        return null;
    }
}
