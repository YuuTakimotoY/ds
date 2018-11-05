package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDao {

	public ArrayList<CategoryBean> cat() {
		// TODO 自動生成されたメソッド・スタブ
		Connection con =null;
		Statement stm =null;
		ResultSet rs =null;

		String url  = "jdbc:mysql://localhost/ec";
		String id   = "root";
		String pass = "password";

		ArrayList<CategoryBean> acb =new ArrayList<CategoryBean>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,id,pass);
			stm = con.createStatement();
			String quary = "select * from category";
			rs  = stm.executeQuery(quary);

				while(rs.next()) {
					CategoryBean cb =new CategoryBean();
					cb.setCat_id(rs.getInt("cat_id"));
					cb.setCat_name(rs.getString("cat_name"));

					acb.add(cb);
				}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(stm!=null)stm.close();
				if(rs!=null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return acb;

	}

	public CategoryBean cat(int id) {
		Connection con =null;
		Statement stm =null;
		PreparedStatement pre =null;
		ResultSet rs =null;

		String url  = "jdbc:mysql://localhost/ec";
		String ids   = "root";
		String pass = "password";

		CategoryBean cb2 =new CategoryBean();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,ids,pass);
			String quary = "select * from category where cat_id=?";
			pre = con.prepareStatement(quary);
			pre.setInt(1, id);
			rs  = pre.executeQuery();

				while(rs.next()) {
					
					cb2.setCat_id(rs.getInt("cat_id"));
					cb2.setCat_name(rs.getString("cat_name"));

					
				}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(stm!=null)stm.close();
				if(rs!=null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cb2;

	}
		// TODO 自動生成されたメソッド・スタブ
		
}



