package com.unis.util.dbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseConnection {

	/**
	 * 1. ��ȡ���ӵķ����� ͨ����ȡ�����ļ������ݿ��������ȡһ������
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws Exception {
		// 1. ׼���������ݿ��4���ַ���
		// (1). ����Properties����
		Properties properties = new Properties();
		// (2). ��ȡjdbc.properties ��Ӧ��������
		InputStream in = DatabaseConnection.class.getClassLoader()
				.getResourceAsStream("jdbc.properties");
		// (3). ���أ�2����Ӧ��������
		properties.load(in);
		// (4). Ϊ�������user��password��4���ַ�����
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String driver = properties.getProperty("driver");
		// 2. �������ݿ��������򣨶�Ӧ��Driver ʵ��������ע�������ľ�̬����飩��
		Class.forName(driver);
		// 3. ͨ��DriverManager ��getConnection()������ȡ���ݿ����ӡ�
		return (Connection) DriverManager
				.getConnection(jdbcUrl, user, password);
	}

	public static void release(ResultSet rs, PreparedStatement statement,
			Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static BasicDataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		try {
			// 1. ׼���������ݿ��4���ַ���
			// (1). ����Properties����
			Properties properties = new Properties();
			// (2). ��ȡjdbc.properties ��Ӧ��������
			InputStream in = DatabaseConnection.class.getClassLoader()
					.getResourceAsStream("jdbc.properties");
			// (3). ���أ�2����Ӧ��������
			properties.load(in);
			// (4). Ϊ�������user��password��4���ַ�����
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String jdbcUrl = properties.getProperty("jdbcUrl");
			String driver = properties.getProperty("driver");
			
			datasource.setDriverClassName(driver);
			datasource.setUrl(jdbcUrl);
			datasource.setUsername(user);
			datasource.setPassword(password);
			datasource.setMaxActive(10);
			datasource.setMaxIdle(5);
			datasource.setMinIdle(2);
			datasource.setInitialSize(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datasource;
	}

}
