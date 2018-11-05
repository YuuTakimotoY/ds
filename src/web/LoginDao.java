package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	public  LoginBean log(String name,String password){
		
		Connection con = null;
		PreparedStatement pre =null;
		ResultSet rs =null;
		
		String url = "jdbc:mysql://localhost/ec";
		String id = "root";
		String pas ="password";
		
		
		LoginBean lb =new LoginBean();
		try {//Jdbcドライバの登録
			Class.forName("com.mysql.jdbc.Driver");
			//コネクションの接続
			con = DriverManager.getConnection(url,id,pas);
			String quarry ="select * from user where user_name=? and login_pw=? ";
			pre = con.prepareStatement(quarry);
			
			pre.setString(1, name);
			pre.setString(2, password);
			rs = pre.executeQuery();
			
			while(rs.next()) {
				lb.setUser_id(rs.getInt("user_id"));
				lb.setUser_name(rs.getString("user_name"));
				lb.setLogin_cd(rs.getString("Login_cd"));
				lb.setLogin_pw(rs.getString("Login_pw"));
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pre!=null) {
					pre.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return lb;
	}
}
