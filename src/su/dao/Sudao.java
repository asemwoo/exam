package su.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import su.dao.Sudao;
import su.vo.Subject;

public class Sudao {
	private static Sudao dao = new Sudao();
	private Sudao() {}
	public static Sudao getInstance() {
		return dao;
}
	public Connection connect() { 
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:8081/su","root","1234");	
		}catch(Exception e) {
			System.out.println("MDAO:connect" +e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt) 
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			} catch (Exception e) {
			 System.out.println("pstmt close error"+e);
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			}catch(Exception e) {
				System.out.println("Conn close error"+e);
			}
		}
	}
	public void close(Connection conn,PreparedStatement pstmt, ResultSet rs) {
		if(rs != null)
		{
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("rs close error" +e);
			}
			close(conn,pstmt);
		}
	}	
	public boolean login(String id, String pwd) { 
		boolean result =false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from account where id =? and pwd =?;");
			pstmt.setString(1,id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}
			else
				result =false ;
			
		}catch(Exception e)
		{
			System.out.println("login error" +e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}
	public void enroll(Subject subject) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?,?,?);");
			pstmt.setString(1, subject.getId());
			pstmt.setString(2, subject.getStu());
			pstmt.setString(3, subject.getNum()+"");
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("enroll error" +e);
		}
		finally
		{
			close(conn,pstmt);
		}
	}
	public boolean search(String subject) { 
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select subj from account where subj =? ;");
			pstmt.setString(1,subject);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}
			
		}catch(Exception e)
		{
			System.out.println("search error" +e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}
}
