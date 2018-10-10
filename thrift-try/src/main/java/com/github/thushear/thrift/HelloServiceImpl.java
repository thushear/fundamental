package com.github.thushear.thrift;

import org.apache.thrift.TException;

public class HelloServiceImpl  implements Hello.Iface
{
    @Override
    public String helloString(String para) throws TException {
        return "hello" + para;
    }

    @Override
    public int helloInt(int para) throws TException {
        return para;
    }

    @Override
    public boolean helloBoolean(boolean para) throws TException {
        return para;
    }

    @Override
    public void helloVoid() throws TException {
        System.err.println("hello void");
    }

    @Override
    public String helloNull() throws TException {
        return "hellonull" ;
    }
}
