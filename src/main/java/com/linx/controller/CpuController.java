package com.linx.controller;

import com.linx.Pojo.CpuDAO;
import com.linx.Pojo.CpuTest;
import com.linx.result.Result;
import com.linx.result.ResultFactory;
import com.linx.service.CephRbd;
import com.linx.service.CpuService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @title: CpuController
 * @Author yqliu
 * @Date: 2022/3/16 下午5:35
 * @Version 1.0
 */
@RestController
public class CpuController {
    @Autowired
    CpuService cpuService;

    // lxdmanager lxdserver 通信接口测试
    @PostMapping(value = "/testcpu")
    @ResponseBody
    public Result TestCpu(@RequestBody CpuTest requestTestCpu) {
        boolean status = cpuService.testCpu(requestTestCpu);
        if (status == true ) {
            return ResultFactory.buildSuccessResult(status);
        } else {
            return ResultFactory.buildFailResult("请求lxdmanager错误!");
        }
    }

    // ceph librados 接口测试
    @GetMapping(value = "/getClusterdata")
    @ResponseBody
    public Result getClusterData() {
        CephRbd crbd = new CephRbd();
        CephRbd ret = crbd.InitCephClient();
        if (ret == null ) {
            return ResultFactory.buildFailResult("获取ceph集群data失败!");
        } else {
            return ResultFactory.buildSuccessResult(ret);
        }
    }

    // lxdserver mariadb 接口测试
    @SneakyThrows
    @GetMapping(value = "/getcpuinfo")
    @ResponseBody
    public Result getCpuInfo() {
        CpuDAO cpuOp = new CpuDAO();
        Object ret = cpuOp.getCpuInfo();
        if (ret == null) {
            return ResultFactory.buildFailResult("获取Cpu信息失败!");
        } else {
            return ResultFactory.buildSuccessResult(ret);
        }
    }
}
