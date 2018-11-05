package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDao {

	public CartBean cad(int se) {
		// TODO 自動生成されたメソッド・スタブ
		CartBean cb = new CartBean();

		String url = "jdbc:mysql://localhost/ec";
		String ids ="root";
		String pass ="password";

		Connection con =null;
		PreparedStatement pre =null;
		ResultSet rs =null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url,ids,pass);
			String quary ="select * from cart where pro_cd = ?";
			pre = con.prepareStatement(quary);
			pre.setInt(1,se);
			rs=pre.executeQuery();

			while(rs.next()) {

				cb.setPro_id(rs.getInt("pro_id"));
				cb.setPro_name(rs.getString("pro_name"));
				cb.setPro_price(rs.getInt("pro_price"));
				cb.setStock_no(rs.getInt("stock_no"));

			}

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pre!=null)pre.close();
				if(rs !=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return cb;
	}

}
