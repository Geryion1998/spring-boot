package com.linx.thrift.iface;

import com.linx.thrift.impl.InvalidOperationException;
import com.linx.thrift.impl.LxdManagerService;
import org.apache.thrift.TException;

/**
 * @title: LxdManagerServiceImpl for java trift test
 * @Author yqliu
 * @Date: 2022/3/16 下午9:15
 * @Version 1.0
 */
public class LxdManagerServiceImpl implements LxdManagerService.Iface {
    @Override
    public boolean TestCpu(String node, int cpus, int time) throws InvalidOperationException, TException {
        return false;
    }

    @Override
    public boolean Ping() throws InvalidOperationException, TException {
        return false;
    }
}
