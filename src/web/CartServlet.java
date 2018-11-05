package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 		req.setCharacterEncoding("UTF-8");
	 		resp.setContentType("text/html;charset=UTF-8");

	 		String cart =req.getParameter("cart");
	 		int cartid =Integer.parseInt(cart);//個数
	 		int se = (int) req.getAttribute("cartid");//pro.cd


	 		CartDao cd = new CartDao();
	 		CartBean cb = cd.cad(se);


	 		Cart2Dao cd2 = new Cart2Dao();
	 		cd2.cad2(cartid,cb);

	 		ArrayList<Cart2Bean> acb2 = cd2.cad3(se);
	 		req.setAttribute("avc",acb2);
	 		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
	 		rd.forward(req, resp);

 	}
}