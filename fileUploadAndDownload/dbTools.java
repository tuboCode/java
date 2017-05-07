package com.cs.cn;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.processing.FilerException;

public class dbTools {

	dbUtil dbu = new dbUtil();
	Connection conn = dbu.getConnection();

	/*
	 * 用户登录
	 */
	public boolean login(user user) throws Exception {
		String sql = "select * from users where username = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 用户注册
	 */
	public boolean register(user user) {
		String sql = "insert into users(username,password) values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * 上传文件
	 */
	public boolean uploadFile(fileEntity fe) {
		String sql = "insert into file(username,filename,filecontent)values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fe.getUserName());
			ps.setString(2, fe.getFileName());
			ps.setBytes(3, fe.getFileContent());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * 下载文件
	 */
	public byte[] downloadFile(fileEntity fe) throws Exception {
		String sql = "select filecontent from file where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, fe.getId());
		ResultSet rs = ps.executeQuery();
		InputStream is = null;
		if (rs.next()) {
			is = rs.getBinaryStream(1);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[is.available()];
			int len;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			return buffer;
		}
		return null;
	}

	/*
	 * 查看文件
	 */
	public ArrayList<fileEntity> viewFile(fileEntity fe) throws Exception {
		ArrayList<fileEntity> fileList = new ArrayList<>();
		String sql = "select id,filename from file where username= ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, fe.getUserName());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			fileList.add(new fileEntity(rs.getInt(1), rs.getString(2)));
		}
		return fileList;
	}

	/*
	 * 删除文件
	 */
	public boolean deleteFile(fileEntity fe) throws Exception {
		String sql = "delete from file where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, fe.getId());
		ps.execute();
		if (ps.getUpdateCount() > 0) {
			return true;
		}
		return false;
	}
}
