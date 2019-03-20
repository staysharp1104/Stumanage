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
	 * 1. 获取连接的方法。 通过读取配置文件从数据库服务器获取一个连接
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws Exception {
		// 1. 准备链接数据库的4个字符串
		// (1). 创建Properties对象
		Properties properties = new Properties();
		// (2). 获取jdbc.properties 对应的输入流
		InputStream in = DatabaseConnection.class.getClassLoader()
				.getResourceAsStream("jdbc.properties");
		// (3). 加载（2）对应的输入流
		properties.load(in);
		// (4). 为具体决定user，password等4个字符串。
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String driver = properties.getProperty("driver");
		// 2. 加载数据库驱动程序（对应的Driver 实现类中有注册驱动的静态代码块）。
		Class.forName(driver);
		// 3. 通过DriverManager 的getConnection()方法获取数据库连接。
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
			// 1. 准备链接数据库的4个字符串
			// (1). 创建Properties对象
			Properties properties = new Properties();
			// (2). 获取jdbc.properties 对应的输入流
			InputStream in = DatabaseConnection.class.getClassLoader()
					.getResourceAsStream("jdbc.properties");
			// (3). 加载（2）对应的输入流
			properties.load(in);
			// (4). 为具体决定user，password等4个字符串。
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
