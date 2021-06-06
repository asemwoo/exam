package su.service;

import su.dao.Sudao; 
import su.service.Service;
import su.vo.Subject;

public class Service {
	private static Service service = new Service();
	private Service() {}  //�ܺ�����
	private Sudao dao = Sudao.getInstance(); //���ΰ�ü dao
	public static Service getInstance() //���ΰ�ü�� ��ȯ�ǵ��� �ϰ��ϴ� �޼ҵ�
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
