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
		var kkChoice; // ���⿡ ���õ� radio ��ư�� ���� ���� �ȴ�.
		for(var i=0; i<kk.length; i++) {
		    if(kk[i].checked) {
		        kkChoice = kk[i].value;
		    }*/
		if(result )
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path="/menus.jsp";	// ���� �α��� �������� �� �����ϴ� ���
		}
		if(result)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path="/menup.jsp";	// �л� �α��� �������� �� �����ϴ� ���
		}
		else
		{ 
			path="/index.jsp";   	// �ƿ� �α��� �������� ��
		}
		HttpUtil.forward(request, response, path);
	}

}
