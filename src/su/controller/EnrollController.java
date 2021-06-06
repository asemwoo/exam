package su.controller;

import java.io.IOException;  

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import su.service.Service;
import su.vo.Subject;

public class EnrollController implements Controller{
	@Override
	public void  execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
	String id = request.getParameter("id");
	String Stu = request.getParameter("Stu");
	int num = request.getIntHeader("num");
	Subject subject= new Subject(id,Stu,num);
	
	Service s = Service.getInstance();//���ΰ�ü
	s.enroll(subject);// enroll�޼ҵ� ȣ��
	
	HttpUtil.forward(request, response, "/index.jsp");
	}
}
