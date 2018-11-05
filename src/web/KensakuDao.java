package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KensakuDao {

	public ArrayList<KensakuBean> ken(String word, int id) {
		ArrayList<KensakuBean> akb = new ArrayList<KensakuBean>();
		
		Connection con =null;
		PreparedStatement pre =null;
		ResultSet rs =null;

		String url="jdbc:mysql://localhost/ec";
		String ids ="root";
		String pass ="password";

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,ids,pass);
			if(word == null){
				//select文で商品情報を取りだす
				String query="select * from product where cat_id = ? ";
				pre=con.prepareStatement(query);
				pre.setInt(1,id);
				rs=pre.executeQuery();

			}else{

				// select文で商品情報を取りだす
				String query = "select* from product";
				//全件検索
				if("".equals(word)&&id==0){
					pre=con.prepareStatement(query);
				//ワード検索
				}else if (!"".equals(word) && id==0) {
					query += " where pro_name like ?";
					pre = con.prepareStatement(query);
					pre.setString(1,"%" + word + "%");
				//カテゴリ検索
				}else if (id != 0 && "".equals(word)) {
					query += " where cat_id=?";
					pre = con.prepareStatement(query);
					pre.setInt(1, id);
				//カテゴリーとワード
				}else if(!"".equals(word) && id!=0){
					query+=" where pro_name like ? AND cat_id=?";
					pre = con.prepareStatement(query);
				  	pre.setString(1,"%" + word + "%");
					pre.setInt(2, id);
				}
			 }
			rs = pre.executeQuery();

		while(rs.next()){

			KensakuBean kb = new KensakuBean();

			kb.setPro_name(rs.getString("pro_name"));
			kb.setPro_cd(rs.getInt("pro_cd"));
			kb.setStock_no(rs.getInt("stock_no"));
			kb.setPro_price(rs.getInt("pro_price"));
			kb.setCat_id(rs.getInt("cat_id"));
			kb.setPro_msg(rs.getString("pro_msg"));
			kb.setPro_img(rs.getString("pro_img"));
			//arrayListに追加
			akb.add(kb);


		}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
		}try {
			if(pre!=null)rs.close();
			if(con!=null) rs.close();
			if(rs!=null) rs.close();
		} catch (Exception ex)  { }

		return akb;
	}

}