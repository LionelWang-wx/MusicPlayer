package com.MusicPlayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
		 static final String DRIVE = "com.mysql.jdbc.Driver";
		 static final String URL = "jdbc:mysql://localhost:3306/music?characterEncoding=utf-8";
		// 建立数据库连接
		public static Connection getConnection() {
			Connection con = null;
			try {
				Class.forName(DRIVE);// 建立一个数据库的连接
				con = DriverManager.getConnection(URL, "root", "");
//				System.out.println("测试连接成功");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
	}

