package com.linx.thrift.thriftfactory;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @title: ThriftFatory
 * @Author yqliu
 * @Date: 2022/3/16 下午7:20
 * @Version 1.0
 */
public class ThriftFatory {
    private ThriftFatory() {}

    private static final Logger LOG = LoggerFactory.getLogger(ThriftFatory.class);
    private static TProtocol protocol;
    private static TTransport transport;

    /**
     * @Author yqliu
     * @Description //获取二进制protocol
     * @Date 下午7:28 2022/3/16
     * @Param []
     * @return org.apache.thrift.protocol.TProtocol
     **/
    public static TProtocol getTProtocol() {
        if (protocol == null) {
            protocol = new TBinaryProtocol(getTTransport());
        }
        return protocol;
    }

    /**
     * @Author yqliu
     * @Description //获取传输对象
     * @Date 下午7:28 2022/3/16
     * @Param []
     * @return org.apache.thrift.transport.TTransport
     **/
    private static TTransport getTTransport() {
        if (transport == null ) {
            //todo 需要修改从配置文件中读取
            String ip = "172.30.25.34";
            Integer port = 18080;
            transport = new TSocket(ip, port);
        }
        return transport;
    }

    /**
     * @Author yqliu
     * @Description //获取客户端实例
     * @Date 下午7:32 2022/3/16
     * @Param [tClass]
     * @return T
     **/
    public static <T> T getClient(Class<T> tClass) {
        T instance = null;
        try {
            //获取有参构造器
            Constructor c = tClass.getConstructor(TProtocol.class);
            //实例化客户端，需要传入 protocol
            instance = (T) c.newInstance(getTProtocol());
        } catch (Exception e) {
            LOG.error("", e);
            throw new RuntimeException(e.getMessage());
        }
        return instance;
    }
    
    /**
     * @Author yqliu
     * @Description //发起请求
     * @Date 下午7:38 2022/3/16
     * @Param [tClass, methodName, params]
     * @return java.lang.Object
     **/
    public static <T> Object doRequest(Class<T> tClass, String methodName, Object... param) {
        Object result = null;
        try {
            //获取客户端实例
            T instance = getClient(tClass);
            Method[] methods = tClass.getMethods();
            for (Method method : methods) {
                // 获取指定的方法
                if (method.getName().equals(methodName)) {
                    open();
                    result = method.invoke(instance, param);
                    close();
                    break;
                }
            }
        } catch (Exception e) {
            LOG.error("", e);
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    /**
     * @Author yqliu
     * @Description //打开传输
     * @Date 下午7:39 2022/3/16
     * @Param []
     * @return void
     **/
    public static void open() {
        try {
            getTTransport().open();
        } catch (TTransportException e) {
            LOG.error("", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * @Author yqliu
     * @Description //关闭传输
     * @Date 下午7:39 2022/3/16
     * @Param []
     * @return void
     **/
    public static void close() {
        getTTransport().close();
    }
}
