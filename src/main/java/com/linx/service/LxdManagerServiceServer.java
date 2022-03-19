package com.linx.service;

import com.linx.thrift.iface.LxdManagerServiceImpl;
import com.linx.thrift.impl.LxdManagerService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @title: LxdManagerServiceServer for Test
 * @Author yqliu
 * @Date: 2022/3/16 下午9:18
 * @Version 1.0
 */
public class LxdManagerServiceServer {
    public void start() throws TTransportException {
        TServerTransport serverTransport = new TServerSocket(9090);
        TSimpleServer server = new TSimpleServer(new TServer.Args(serverTransport)
                .processor(new LxdManagerService.Processor<>(new LxdManagerServiceImpl())));

        System.out.print("Starting the server... ");

        server.serve();

        System.out.println("done.");
    }

    public void stop() {
        TServer server = null;
        if (server != null && server.isServing()) {
            System.out.print("Stopping the server... ");

            server.stop();

            System.out.println("done.");
        }
    }
}
