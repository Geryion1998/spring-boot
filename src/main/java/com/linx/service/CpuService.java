package com.linx.service;

import com.linx.Pojo.CpuTest;
import com.linx.thrift.impl.LxdManagerService;
import com.linx.thrift.thriftfactory.ThriftFatory;
import org.springframework.stereotype.Service;

/**
 * @title: CpuService
 * @Author yqliu
 * @Date: 2022/3/15 下午1:46
 * @Version 1.0
 */
@Service
public class CpuService {
    /**
     * @Author yqliu
     * @Description //TODO 完善TestCpu
     * @Date 下午7:01 2022/3/16
     * @Param [cpu]
     * @return boolean
     **/
    public boolean testCpu(CpuTest cpu) {
        return (boolean) ThriftFatory.doRequest(LxdManagerService.Client.class, "TestCpu", cpu.getNode(), cpu.getCpus(), cpu.getTime());
    }
}
