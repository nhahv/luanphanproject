/**
 * 
 */
package com.asnet.luanphan.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.asnet.luanphan.client.datamodel.User;

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
				+ USERS_TABLENAME + ".User_loginname='" + user.loginname + "' AND "
				+ USERS_TABLENAME + ".User_password='" + user.password + "'";
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
	public boolean isExistUserLoginname(String loginname){
		boolean result = false;
		
		//cau lenh mysql select du lieu theo user va password nhap vao
		String query = "SELECT * FROM " + USERS_TABLENAME + " WHERE "
				+ USERS_TABLENAME + ".User_loginname='" + loginname +"'";
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
	public void insertDBUser(User user){
		String query="";		
		query = "insert into " + USERS_TABLENAME + 
		          "(" + USERS_TABLENAME+".user_name, " + USERS_TABLENAME +".user_loginname, "+
						USERS_TABLENAME+".user_password, " + USERS_TABLENAME+ ".user_sess, " + 
						USERS_TABLENAME+".user_email, " + USERS_TABLENAME +".user_join, " +
						USERS_TABLENAME+".user_lastvisit, " + USERS_TABLENAME +".user_currentvisit, " + 
						USERS_TABLENAME +".user_ban) values('" + 
						user.username +"', '" + user.loginname + "', '" + user.password +"', '" + user.userSess
						+"', '"+ user.useremail +"', '"+ user.userJoin +"', '"+ user.userLastVisit +"', '"+ 
						user.userCurrentVisit +"', '"+ user.userBan +"')";
		try {
			Connection conn = getConnection();
			Statement insert = conn.createStatement();
			System.out.println(insert.execute(query));
			conn.close();				

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
}
