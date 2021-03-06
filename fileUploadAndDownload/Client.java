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

	/* * 发送对象 */ public void sendData(commonRealy cr) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(cr);
		oos.flush();
	}

	/* * 接收对象 */ public commonRealy getData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		commonRealy cr = (commonRealy) ois.readObject();
		return cr;
	}

	/* * 用户登陆 */ public void login() throws Exception {
		System.out.println("*********开始登陆帐号***********");
		int count = 0;
		commonRealy cr = new commonRealy();
		while (true) {
			System.out.print("请输入帐号: ");
			username = input.next();
			user.setUserName(username);
			System.out.print("请输入密码: ");
			user.setPassword(input.next());
			count++;
			if (count == 3) {
				System.out.println("密码错误3次,退出系统!");
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
				System.out.println("帐号或密码输入错误,请重新输入!");
				continue;
			}
		}
		System.out.println("登陆成功,进入文件上传下载器!");
		fileMain();
	}

	/* * 用户注册 */ public void register() throws Exception {
		System.out.println("**********开始注册帐号**********");
		String confirm = null;
		commonRealy cr = new commonRealy();
		while (true) {
			System.out.print("请输入帐号: ");
			username = input.next();
			System.out.print("请输入密码: ");
			password = input.next();
			System.out.print("请再次输入密码: ");
			confirm = input.next();
			if (!password.equals(confirm)) {
				System.out.println("两次密码不一致,请重新输入!");
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
				System.out.println("注册失败,请重新注册!");
				continue;
			}
		}
		System.out.println("注册成功请登陆!");
		login();
	}

	/* * 文件上传下载界面 */ public void fileMain() throws Exception {
		System.out.println("********文件上传下载界面*********");
		System.out.print("1.上传\n2.下载\n3.查看\n4.删除\n5.退出\n请输入: ");
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
				System.out.println("欢迎下次使用,再见!");
				System.exit(0);
				break;
			default:
				System.out.println("输入指令不正确,请重新输入");
				continue;
			}
			break;
		}
	}

	/* * 文件上传 */ @SuppressWarnings("resource")
	public void upload() throws Exception {
		System.out.println("***********上传文件************");
		System.out.println("请输入上传路径(如 D:/file/bear.jpg):");
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
			System.out.println("上传成功,返回主界面!");
			fileMain();
		} else {
			System.out.println("上传失败,请重新上传!");
		}
		close();
	}

	/* * 文件查看 */ public void view() throws Exception {
		System.out.println("***********查看文件************");
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
			System.out.println("编号\t文件名");
			for (fileEntity fileEntity : fileList) {
				System.out.println(fileEntity);
			}
		} else {
			System.out.println("没有文件,还未上传文件!");
		}
		fileMain();
		close();
	}

	/* * 文件下载 */ @SuppressWarnings("resource")
	public void download() throws Exception {
		System.out.println("***********下载文件************");
		System.out.print("请输入要下载文件的编号:");
		fileEntity fe = new fileEntity();
		fe.setId(input.nextInt());
		System.out.println("请输入下载路径(如 D:/file/bear.jpg):");
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
			System.out.println("下载成功,返回主界面!");
		} else {
			System.out.println("下载失败,没有此文件!");
		}
		fileMain();
		close();
	}

	/* * 删除文件 */ public void delete() throws Exception {
		System.out.println("***********删除文件************");
		System.out.print("请输入要删除文件的编号:");
		fileEntity fe = new fileEntity();
		fe.setId(input.nextInt());
		commonRealy cr = new commonRealy();
		cr.setCommand("delete");
		cr.setFileObject(fe);
		socket = new Socket("localhost", 8722);
		sendData(cr);
		cr = getData();
		if (cr.isFlag()) {
			System.out.println("删除成功,返回主界面!");
		} else {
			System.out.println("删除失败,没有此文件!");
		}
		fileMain();
		close();
	}

	/* * 关闭资源 */ public void close() {
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
		System.out.println("*****欢迎使用xk文件上传下载器*****");
		String flag = null;
		while (true) {
			System.out.print("1.登陆\n2.注册\n3.退出\n请输入: ");
			flag = client.input.next();
			switch (flag) {
			case "1":
				client.login();
				break;
			case "2":
				client.register();
				break;
			case "3":
				System.out.println("欢迎下次使用,再见!");
				System.exit(0);
				break;
			default:
				System.out.println("输入指令不正确,请重新输入");
				continue;
			}
			break;
		}
	}
}
