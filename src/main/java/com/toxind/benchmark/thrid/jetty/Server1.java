package com.toxind.benchmark.thrid.jetty;

import org.mortbay.jetty.Server;

public class Server1 {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8081);
		server.setHandler(new HelloHandler());
        server.start();
        server.join();

	}
}
