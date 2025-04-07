package com.app.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
	public static Connection getConnection() {
		Connection conn = null;
		String userName = "scott";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("연결 정보 오류");
			e.printStackTrace();
			
		} catch(Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		}
		
		return conn;
	}
}







