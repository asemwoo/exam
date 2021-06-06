package su.controller;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import su.service.Service;
 
public class LoginController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		boolean check = request.authenticate(response);
		
		Service s = Service.getInstance();
		boolean result = s.login(id,pwd);
		boolean x;
		String path = null;
		/*var kk = document.getElementsByName('kk');
		var kkChoice; // 여기에 선택된 radio 버튼의 값이 담기게 된다.
		for(var i=0; i<kk.length; i++) {
		    if(kk[i].checked) {
		        kkChoice = kk[i].value;
		    }*/
		if(result )
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path="/menus.jsp";	// 교수 로그인 성공했을 때 가야하는 경로
		}
		if(result)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path="/menup.jsp";	// 학생 로그인 성공했을 때 가야하는 경로
		}
		else
		{ 
			path="/index.jsp";   	// 아예 로그인 실패했을 때
		}
		HttpUtil.forward(request, response, path);
	}

}
