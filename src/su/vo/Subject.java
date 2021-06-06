package su.vo;

public class Subject {
	private String id;
	private String Stu;
	private int num;
	public Subject () {}
		public Subject(String tId, String tStu, int tNum)
		{
			this.id=tId;
			this.Stu= tStu;
			this.num=tNum;
		}
		public String getId()
		{
			return id;
		}
		public void setId(String tId)
		{
			this.id= tId;
		}
		
		public String getStu()
		{
			return Stu;
		}
		public void setStu(String tStu)
		{
			this.Stu= tStu;
		}
		public	int getNum()
		{
			return num;
		}
		public void setNum(int tNum)
		{
			this.num= tNum;
		}
}
