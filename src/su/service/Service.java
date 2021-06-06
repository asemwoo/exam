package su.service;

import su.dao.Sudao; 
import su.service.Service;
import su.vo.Subject;

public class Service {
	private static Service service = new Service();
	private Service() {}  //외부접근
	private Sudao dao = Sudao.getInstance(); //내부객체 dao
	public static Service getInstance() //내부객체가 반환되도록 하게하는 메소드
	{
		return service;
	} 
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(id,pwd);
	}
	public void enroll(Subject subject) {
		// TODO Auto-generated method stub
		dao.enroll(subject);
	}
	public boolean search(String subject) {
		// TODO Auto-generated method stub
		return dao.search(subject);
	}


}
