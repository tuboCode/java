package com.cs.cn;

import java.util.ArrayList;

public class commonRealy {

	private String command;
	private boolean flag;
	private Object userObject = null;
	private Object fileObject = null;
	private byte[] bytes = null;
	private ArrayList<fileEntity> filelist = null;
	public ArrayList<fileEntity> getFilelist() {
		return filelist;
	}
	public void setFilelist(ArrayList<fileEntity> filelist) {
		this.filelist = filelist;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Object getUserObject() {
		return userObject;
	}
	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}
	public Object getFileObject() {
		return fileObject;
	}
	public void setFileObject(Object fileObject) {
		this.fileObject = fileObject;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
}
