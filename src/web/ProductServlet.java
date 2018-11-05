package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String ids =req.getParameter("pro_cd");
		int id =Integer.parseInt(ids);
		
		ProductDao sd = new ProductDao();
		ProductBean sb = sd.sho(id);
		
		CategoryDao cd =new CategoryDao();
		CategoryBean cb2 = cd.cat(id);
		
		req.setAttribute("ca",cb2);
		req.setAttribute("sho", sb);
		
		RequestDispatcher rd = req.getRequestDispatcher("product.jsp");
		rd.forward(req, resp);
	}
}
