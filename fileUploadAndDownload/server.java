package com.cs.cn;

import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws Exception{
		//服务器套接字
		ServerSocket ss = new ServerSocket(8888);
		//客户端套接字
		Socket socket = null;
		System.out.println("服务器程序已经启动");
		while(true){
			socket = ss.accept();
			serverThread st = new serverThread(socket);
			st.start();
		}
	}
}
