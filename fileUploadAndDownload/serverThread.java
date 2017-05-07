package com.cs.cn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class serverThread extends Thread {
	Socket socket = null;

	public serverThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			commonRealy cr = (commonRealy) ois.readObject();
			cr = inquire(cr);
			oos.writeObject(cr);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private commonRealy inquire(commonRealy cr) throws Exception {
		user user = (com.cs.cn.user) cr.getUserObject();
		fileEntity fe = (fileEntity) cr.getFileObject();
		dbTools dbt = new dbTools();
		boolean flag = false;
		switch (cr.getCommand()) {
		case "longin":
			flag = dbt.login(user);
			break;
		case "register":
			flag = dbt.register(user);
			break;
		case "upload":
			flag = dbt.uploadFile(fe);
			break;
		case "view":
			ArrayList<fileEntity> fileList = dbt.viewFile(fe);
			if (fileList.isEmpty()) {
				flag = true;
				cr.setFilelist(fileList);
			}
			break;
		case "download":
			byte[] bytes = dbt.downloadFile(fe);
			if (bytes != null) {
				flag = true;
				cr.setBytes(bytes);
			}
			break;
		case "delete":
			flag = dbt.deleteFile(fe);
			break;
		default:
			break;
		}
		cr.setFlag(flag);
		return cr;
	}
}
