package su.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import su.controller.HttpUtil;
import su.service.Service;

public class SearchController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String subject = request.getParameter("subject");
		
		boolean result = Service.getInstance().search(subject);
		String msg =null;
		if(result ==false)
			msg ="false";
		else
			msg = "true";
		request.setAttribute("subject",subject);
		HttpUtil.forward(request, response, "/enroll.jsp");
		
	}

}
