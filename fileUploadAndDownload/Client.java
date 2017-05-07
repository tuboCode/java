package com.cs.cn;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	String username = null;
	String password = null;
	Socket socket = null;
	user user = new user();
	fileEntity fe = null;
	Scanner input = new Scanner(System.in);

	/* * ���Ͷ��� */ public void sendData(commonRealy cr) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(cr);
		oos.flush();
	}

	/* * ���ն��� */ public commonRealy getData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		commonRealy cr = (commonRealy) ois.readObject();
		return cr;
	}

	/* * �û���½ */ public void login() throws Exception {
		System.out.println("*********��ʼ��½�ʺ�***********");
		int count = 0;
		commonRealy cr = new commonRealy();
		while (true) {
			System.out.print("�������ʺ�: ");
			username = input.next();
			user.setUserName(username);
			System.out.print("����������: ");
			user.setPassword(input.next());
			count++;
			if (count == 3) {
				System.out.println("�������3��,�˳�ϵͳ!");
				System.exit(0);
			}
			cr.setCommand("login");
			cr.setUserObject(user);
			socket = new Socket("localhost", 8722);
			sendData(cr);
			cr = getData();
			if (cr.isFlag()) {
				break;
			} else {
				System.out.println("�ʺŻ������������,����������!");
				continue;
			}
		}
		System.out.println("��½�ɹ�,�����ļ��ϴ�������!");
		fileMain();
	}

	/* * �û�ע�� */ public void register() throws Exception {
		System.out.println("**********��ʼע���ʺ�**********");
		String confirm = null;
		commonRealy cr = new commonRealy();
		while (true) {
			System.out.print("�������ʺ�: ");
			username = input.next();
			System.out.print("����������: ");
			password = input.next();
			System.out.print("���ٴ���������: ");
			confirm = input.next();
			if (!password.equals(confirm)) {
				System.out.println("�������벻һ��,����������!");
				continue;
			}
			user.setUserName(username);
			user.setPassword(password);
			cr.setCommand("register");
			cr.setUserObject(user);
			socket = new Socket("localhost", 8722);
			sendData(cr);
			cr = getData();
			if (cr.isFlag()) {
				break;
			} else {
				System.out.println("ע��ʧ��,������ע��!");
				continue;
			}
		}
		System.out.println("ע��ɹ����½!");
		login();
	}

	/* * �ļ��ϴ����ؽ��� */ public void fileMain() throws Exception {
		System.out.println("********�ļ��ϴ����ؽ���*********");
		System.out.print("1.�ϴ�\n2.����\n3.�鿴\n4.ɾ��\n5.�˳�\n������: ");
		String flag = null;
		while (true) {
			flag = input.next();
			switch (flag) {
			case "1":
				upload();
				break;
			case "2":
				download();
				break;
			case "3":
				view();
				break;
			case "4":
				delete();
				break;
			case "5":
				System.out.println("��ӭ�´�ʹ��,�ټ�!");
				System.exit(0);
				break;
			default:
				System.out.println("����ָ���ȷ,����������");
				continue;
			}
			break;
		}
	}

	/* * �ļ��ϴ� */ @SuppressWarnings("resource")
	public void upload() throws Exception {
		System.out.println("***********�ϴ��ļ�************");
		System.out.println("�������ϴ�·��(�� D:/file/bear.jpg):");
		String path = input.next();
		String filename = path.substring(path.lastIndexOf('/') + 1);
		FileInputStream fis = new FileInputStream(path);
		byte[] fileBytes = new byte[fis.available()];
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.read(fileBytes);
		fileEntity fe = new fileEntity();
		fe.setUserName(username);
		fe.setFileName(filename);
		fe.setFileContent(fileBytes);
		commonRealy cr = new commonRealy();
		cr.setCommand("upload");
		cr.setFileObject(fe);
		socket = new Socket("localhost", 8722);
		sendData(cr);
		cr = getData();
		if (cr.isFlag()) {
			System.out.println("�ϴ��ɹ�,����������!");
			fileMain();
		} else {
			System.out.println("�ϴ�ʧ��,�������ϴ�!");
		}
		close();
	}

	/* * �ļ��鿴 */ public void view() throws Exception {
		System.out.println("***********�鿴�ļ�************");
		fileEntity fe = new fileEntity();
		fe.setUserName(username);
		commonRealy cr = new commonRealy();
		cr.setCommand("view");
		cr.setFileObject(fe);
		socket = new Socket("localhost", 8722);
		sendData(cr);
		cr = getData();
		if (cr.isFlag()) {
			ArrayList<fileEntity> fileList = cr.getFilelist();
			System.out.println("���\t�ļ���");
			for (fileEntity fileEntity : fileList) {
				System.out.println(fileEntity);
			}
		} else {
			System.out.println("û���ļ�,��δ�ϴ��ļ�!");
		}
		fileMain();
		close();
	}

	/* * �ļ����� */ @SuppressWarnings("resource")
	public void download() throws Exception {
		System.out.println("***********�����ļ�************");
		System.out.print("������Ҫ�����ļ��ı��:");
		fileEntity fe = new fileEntity();
		fe.setId(input.nextInt());
		System.out.println("����������·��(�� D:/file/bear.jpg):");
		String filename = input.next();
		commonRealy cr = new commonRealy();
		cr.setCommand("download");
		cr.setFileObject(fe);
		socket = new Socket("localhost", 8722);
		sendData(cr);
		cr = getData();
		if (cr.isFlag()) {
			byte[] bytes = cr.getBytes();
			FileOutputStream out = new FileOutputStream(filename);
			out.write(bytes);
			System.out.println("���سɹ�,����������!");
		} else {
			System.out.println("����ʧ��,û�д��ļ�!");
		}
		fileMain();
		close();
	}

	/* * ɾ���ļ� */ public void delete() throws Exception {
		System.out.println("***********ɾ���ļ�************");
		System.out.print("������Ҫɾ���ļ��ı��:");
		fileEntity fe = new fileEntity();
		fe.setId(input.nextInt());
		commonRealy cr = new commonRealy();
		cr.setCommand("delete");
		cr.setFileObject(fe);
		socket = new Socket("localhost", 8722);
		sendData(cr);
		cr = getData();
		if (cr.isFlag()) {
			System.out.println("ɾ���ɹ�,����������!");
		} else {
			System.out.println("ɾ��ʧ��,û�д��ļ�!");
		}
		fileMain();
		close();
	}

	/* * �ر���Դ */ public void close() {
		input.close();
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		Client client = new Client();
		System.out.println("*****��ӭʹ��xk�ļ��ϴ�������*****");
		String flag = null;
		while (true) {
			System.out.print("1.��½\n2.ע��\n3.�˳�\n������: ");
			flag = client.input.next();
			switch (flag) {
			case "1":
				client.login();
				break;
			case "2":
				client.register();
				break;
			case "3":
				System.out.println("��ӭ�´�ʹ��,�ټ�!");
				System.exit(0);
				break;
			default:
				System.out.println("����ָ���ȷ,����������");
				continue;
			}
			break;
		}
	}
}
