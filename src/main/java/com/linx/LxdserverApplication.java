package com.linx;

import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LxdserverApplication {

	public static void main(String[] args) throws TTransportException {
		SpringApplication.run(LxdserverApplication.class, args);
		// java thrift test server
//		LxdManagerServiceServer server = new LxdManagerServiceServer();
//		server.start();
//		boolean b = (boolean) ThriftFator
//		y.doRequest(LxdManagerService.Client.class, "TestCpu", "node1", 1);
//		System.out.println(b);
	}
}
