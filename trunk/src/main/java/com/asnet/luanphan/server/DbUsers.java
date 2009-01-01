/**
 * 
 */
package com.asnet.luanphan.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.asnet.luanphan.client.datamodel.User;
import com.google.gwt.user.client.Window;

/**
 * @author luanphan
 * 
 */
public class DbUsers extends DbConnection {
	/**
	 * Kiem tra user co ton tai trong co so du lieu
	 * @param user
	 * @return
	 */
	public boolean isUserValid(User user) {
		boolean result = false;
		
		//cau lenh mysql select du lieu theo user va password nhap vao
		String query = "SELECT * FROM " + USERS_TABLENAME + " WHERE "
				+ USERS_TABLENAME + ".User_Loginname='" + user.loginname + "' AND "
				+ USERS_TABLENAME + ".User_Password='" + user.password + "'";
		//thuc thi cau lenh
		try {
			Connection conn = getConnection();
			Statement select = conn.createStatement();
			ResultSet rs = select.executeQuery(query);
			if (rs.first()) {
				rs.close();
				conn.close();
				return true;
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		//tra ve true neu user and password valid
		return result;
	}
}
