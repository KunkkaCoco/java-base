package com.rpc;

public class HelloRpcImpl implements HelloRpc {

	@Override
	public String hello(String name) {
		String string = "hello " + name;
		return string;
	}

}
