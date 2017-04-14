package com.cs.cn;

import java.sql.*;

public class JdbcTest {
	
   // JDBC ���������� �����ݿ��ַ
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   
   //���ݿ������Ϊ EXAMPLE
   static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";

   //  ���ݿ��û�������
   static final String USER = "root";

   static final String PASS = " ";

   public static void main(String[] args) {
       Connection conn = null;
       Statement stmt = null;
       try{
    	   
           //ע��JDBC ��������
           Class.forName("com.mysql.jdbc.Driver");

           //������
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //ִ�в�ѯ
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           
           String sql = "SELECT id, name, age FROM Students";
           ResultSet rs = stmt.executeQuery(sql);

           //�õ��ʹ�������
           while(rs.next()){
               //����
               int id  = rs.getInt("id");
               int age = rs.getInt("age");
               String name = rs.getString("name");

               //��ʾ
               System.out.print("ID: " + id);
               System.out.print(", Age: " + age);
               System.out.print(", Name: " + name);
               System.out.println();
           }
           //������
           rs.close();
           stmt.close();
           conn.close();
       }catch(SQLException se){
           // JDBC ��������
           se.printStackTrace();
       }catch(Exception e){
           // Class.forName ����
           e.printStackTrace();
       }finally{
           //����һ�������ر���Դ��
           try{
               if(stmt!=null)
                   stmt.close();
           }catch(SQLException se2){
           }
           try{
               if(conn!=null)
                   conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }
       }
       System.out.println("Goodbye!");
   }
}