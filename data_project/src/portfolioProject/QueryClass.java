package portfolioProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class QueryClass {

	public static HashSet<Student> selectQueryStudent() throws Exception {
		HashSet<Student> hs = new HashSet<Student>();
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String selectQuery = "select * from scoreTBL";
		
		try
		{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.executeQuery();
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int stuNo = resultSet.getInt(1);
				String stuName = resultSet.getString(2);
				String id = resultSet.getString(3);
				String stuEmail = resultSet.getString(4);
				int age = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String stuPhone = resultSet.getString(7);
				
				Student student = new Student(stuNo, stuName, id, stuEmail, age, address, stuPhone);
				hs.add(student);
			}
		}
		catch(Exception e)
		{
			System.out.println("출력부분 에러" + e.toString());
		}
		finally 
		{
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
			if(connection != null)
			{
				connection.close();
			}
		}

		return hs;
	}//print

	public static Student selectQueryStudentWhereNo(int no) throws Exception {
		Student student = null;
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String selectQuery = "select * from scoreTBL where stuNo = ?";
		
		try 
		{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, no);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int stuNo = resultSet.getInt(1);
				String stuName = resultSet.getString(2);
				String id = resultSet.getString(3);
				String stuEmail = resultSet.getString(4);
				int age = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String stuPhone = resultSet.getString(7);
				
				student = new Student(stuNo, stuName, id, stuEmail, age, address, stuPhone);
			}//while
		} //try
		catch (Exception e) 
		{
			System.out.println("select query error" + e.toString());
		}
		finally 
		{
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
			if(connection != null)
			{
				connection.close();
			}
		}
		return student;
	}//whereno

	public static boolean insertQueryStudentInfo(Student insertStudent) throws Exception {
		boolean flag = false;
		Connection connection = DBUtil.getConnection();
		String insertQuery = "insert into studentTBLvalues( ?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement preparedStatement = null;
		try
		{
			preparedStatement =  connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, insertStudent.getStuNo());
			preparedStatement.setString(2, insertStudent.getStuName());
			preparedStatement.setString(3, insertStudent.getId());
			preparedStatement.setString(4, insertStudent.getStuEmail());
			preparedStatement.setInt(5, insertStudent.getAge());
			preparedStatement.setString(6, insertStudent.getAddress());
			preparedStatement.setString(7, insertStudent.getStuPhone());
			
			int count = preparedStatement.executeUpdate();
			
			if(count == 1)
			{
				System.out.println(insertStudent.getStuName() + "님의 추가가 성공적으로 완료되었습니다.");
				flag = true;
			}
			else
			{
				System.out.println(insertStudent.getStuName() + "님의 추가가 비정상적으로 종료되었습니다.");
			}
		}
		catch(Exception e)
		{
			System.out.println("오류가 발생했습니다.");
			e.printStackTrace();
		}
		finally
		{
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
			if(connection != null)
			{
				connection.close();
			}
		}
		return flag;
	}//insert

	public static boolean deleteQueryWhereNO(int no) throws Exception {
		boolean flag = false;
		Connection connection = DBUtil.getConnection();
		
		String deleteQuery = "delete from scoreTBL where stuNo = ?";
		PreparedStatement preparedStatement =null; 
		
		try
		{
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, no);
			
			int count = preparedStatement.executeUpdate();
			if(count == 1)
			{
				System.out.println("삭제를 완료했습니다");
				flag = true;
			}
			else
			{
				System.out.println("삭제가 비정상적으로 종료되었습니다.");
			}
		}
		catch(Exception e)
		{
			System.out.println("삭제 부분 오류 발생");
		}
		finally
		{
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
			if(connection != null)
			{
				connection.close();
			}
		}//finally
		return false;
	}//delete

	public static HashSet<Student> selectQueryStudentWhereName(String name) throws Exception {
		HashSet<Student> hs = new HashSet<Student>();
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		name = '%' +name+'%';
		String selectQuery = "select * from scoreTBL Where name like ?";
		
		try
		{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
					
			while(resultSet.next())
			{
				int stuNo = resultSet.getInt(1);
				String stuName = resultSet.getString(2);
				String id = resultSet.getString(3);
				String stuEmail = resultSet.getString(4);
				int age = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String stuPhone = resultSet.getString(7);
				Student student = new Student(stuNo, stuName, id, stuEmail, age, address, stuPhone);
				hs.add(student);
			}
		}//try
		catch(Exception e)
		{
			System.out.println("select query where name error" + e.toString());
		}
		finally 
		{
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
			if(connection != null)
			{
				connection.close();
			}
		
		}
		
		return hs;
	}

	public static HashSet<Student> selectNumQueryStudent() throws Exception {
		HashSet<Student> hs = new HashSet<Student>();
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String selectQuery = "select * from studentTBL";
		
		try
		{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.executeQuery();
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int stuNo = resultSet.getInt(1);
				String stuName = resultSet.getString(2);
				String id = resultSet.getString(3);
				String stuEmail = resultSet.getString(4);
				int age = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String stuPhone = resultSet.getString(7);
				
				Student student = new Student(stuNo, stuName, id, stuEmail, age, address, stuPhone);
				hs.add(student);
			}
		}
		catch(Exception e)
		{
			System.out.println("출력부분 에러" + e.toString());
		}
		finally 
		{
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
			if(connection != null)
			{
				connection.close();
			}
		}

		return hs;
	}

}







































