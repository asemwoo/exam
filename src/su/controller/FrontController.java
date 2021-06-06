package su.controller;

import java.io.IOException;  
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> map = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Controller>();
		map.put("/login.do",new LoginController());
		map.put("/enroll.do", new EnrollController());
	} 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	// TODO Auto-generated method stub
	String uri = req.getRequestURI(); 
	String contextPath = req.getContextPath();
	String path = uri.substring(contextPath.length());
	
	Controller cont = map.get(path);
	cont.execute(req,resp);
	}

}
