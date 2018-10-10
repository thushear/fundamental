package com.github.thushear.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class HelloServiceClient {


    public static void main(String[] args) throws TException {

        TTransport tTransport = new TSocket("localhost",7911);
        tTransport.open();
        TProtocol tProtocol = new TBinaryProtocol(tTransport);
        Hello.Client client = new Hello.Client(tProtocol);
        String echoStr = client.helloString("thrift");
        System.err.println("echo:" + echoStr);
        tTransport.close();

    }


}
