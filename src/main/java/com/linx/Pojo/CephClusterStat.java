package com.linx.Pojo;

import com.ceph.rados.jna.RadosClusterInfo;

/**
 * @title: CephClusterStar
 * @Author yqliu
 * @Date: 2022/3/17 下午7:17
 * @Version 1.0
 */
public class CephClusterStat {
    long kb;
    long kb_used;
    long kb_avail;
    long num_objects;

    public long getKb() {
        return kb;
    }

    public void setKb(long kb) {
        this.kb = kb;
    }

    public long getKb_used() {
        return kb_used;
    }

    public void setKb_used(long kb_used) {
        this.kb_used = kb_used;
    }

    public long getKb_avail() {
        return kb_avail;
    }

    public void setKb_avail(long kb_avail) {
        this.kb_avail = kb_avail;
    }

    public long getNum_objects() {
        return num_objects;
    }

    public void setNum_objects(long num_objects) {
        this.num_objects = num_objects;
    }
}
