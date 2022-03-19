package com.linx.Pojo;

/**
 * @title: CpuTest
 * @Author yqliu
 * @Date: 2022/3/16 下午5:37
 * @Version 1.0
 */
public class CpuTest {
    int id;
    int time;
    String node;
    int cpus;

    public int getCpus() {
        return cpus;
    }

    public void setCpus(int cpus) {
        this.cpus = cpus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
}
