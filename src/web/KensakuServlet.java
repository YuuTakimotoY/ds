package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KensakuServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			String word = req.getParameter("word");
			String i =req.getParameter("cat_id");
			int id =Integer.parseInt(i);
			KensakuDao kd = new KensakuDao();
			ArrayList<KensakuBean> akb = kd.ken(word,id);

			req.setAttribute("kensaku", akb);

			RequestDispatcher rd = req.getRequestDispatcher("kensaku.jsp");
			rd.forward(req, resp);
	}
}
