package web;

public class CartBean {
		private int pro_id;
		private String pro_name;
		public int getPro_id() {
			return pro_id;
		}
		public void setPro_id(int pro_id) {
			this.pro_id = pro_id;
		}
		public String getPro_name() {
			return pro_name;
		}
		public void setPro_name(String pro_name) {
			this.pro_name = pro_name;
		}
		public int getStock_no() {
			return stock_no;
		}
		public void setStock_no(int stock_no) {
			this.stock_no = stock_no;
		}
		public int getPro_price() {
			return pro_price;
		}
		public void setPro_price(int pro_price) {
			this.pro_price = pro_price;
		}
		private int stock_no;
		private int pro_price;


}
