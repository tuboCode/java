package com.cs.cn;

import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws Exception{
		//�������׽���
		ServerSocket ss = new ServerSocket(8888);
		//�ͻ����׽���
		Socket socket = null;
		System.out.println("�����������Ѿ�����");
		while(true){
			socket = ss.accept();
			serverThread st = new serverThread(socket);
			st.start();
		}
	}
}
