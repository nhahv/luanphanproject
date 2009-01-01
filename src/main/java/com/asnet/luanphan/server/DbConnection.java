/**
 * 
 */
package com.asnet.luanphan.server;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author luanphan
 *
 */
public class DbConnection {
	static final String USERS_TABLENAME="User";
	public Connection getConnection() {

		Connection conn = null;

		
		String url = "jdbc:mysql://localhost:3306/";

		String db = "gwt_luanphan";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String pass = "mysql";

		try {

			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + db, user, pass);

		} catch (Exception e) {

//			MessageBox.alert(e.getMessage());
			System.out.println("Error" +e);
		}
		
		
		return conn;
	}
}
