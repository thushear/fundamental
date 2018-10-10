package com.github.thushear.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;


public class HelloServiceServer {


    public static void main(String[] args) throws TTransportException {

        TServerSocket tServerSocket = new TServerSocket(7911);

        TProcessor tProcessor = new Hello.Processor<>(new HelloServiceImpl());

        TServer tServer = new TSimpleServer(new TServer.Args(tServerSocket).processor(tProcessor));

        tServer.serve();
    }

}
