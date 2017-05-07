package com.cs.cn;

import java.io.Serializable;

public class fileEntity implements Serializable{

	private String userName;
	private String fileName;
	private int id;
	private byte[] fileContent;
	
	public fileEntity(int id,String fileName){
		this.id = id;
		this.fileName = fileName;
	}
	public fileEntity(){}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	public String toString(){
		return id + "\t" + fileName;
	}
}
