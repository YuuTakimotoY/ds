package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		/////LoguinDaoで例外が起こるとそこで止まるのでダメ/////
		//LoginDao ld =new LoginDao();
		//LoginBean lb =ld.log(user, pass);


		String user = req.getParameter("name");
		String pass =req.getParameter("password");

		String next ="";

		if((user.isEmpty())||((pass.isEmpty()))) {

			req.setAttribute("null","no");
	    	next = "login.jsp";
		}else{

			LoginDao ld =new LoginDao();
			LoginBean lb =ld.log(user, pass);

			if(lb.getUser_name()!=null) {//daoで値が正しいか判別しているで

				CategoryDao cate= new CategoryDao();
				ArrayList<CategoryBean>acb=cate.cat();
				//セッション開始
				HttpSession session = req.getSession(true);
				session.setAttribute("lb", lb);
	    		session.setAttribute("categ",acb);
	    		next = "Kensaku.jsp";
			}else {

				req.setAttribute("error", "kuso");
				next ="login.jsp";
			}





		}RequestDispatcher rd = req.getRequestDispatcher(next);
    	rd.forward(req, resp);
	}
}
