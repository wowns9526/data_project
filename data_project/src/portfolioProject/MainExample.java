package portfolioProject;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class MainExample {
	
	public static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		boolean flag = false;
		
		while(!flag)
		{
			System.out.print("1)데이터 조회  2)데이터 입력  3)데이터 삭제  4)데이터 검색   5)종료");
			int select = sc.nextInt();
			switch (select) {
			case 1: printData();
				break;
			case 2: insertData();
				break;
			case 3: deleteData();
				break;
			case 4: searchData();
				break;
			case 5: flag = true;
				break;
			default: System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
				break;
			}
		}//while
		System.out.println("프로그램을 종료합니다.");
		
	}//main
	private static void searchData() {
		boolean flag = false;
		try
		{
			while(!flag)
			{
				System.out.print("1)이름으로 검색   2)번호로 검색   3)종료  >>   ");
				int num = sc.nextInt();
				switch (num) {
					case 1: 
						System.out.print("검색하실 이름을 입력하십시오  >>  ");
						String name = sc.next();
						HashSet<Student> hashSet = QueryClass.selectQueryStudentWhereName(name);
						if(hashSet != null)
						{
							Iterator<Student> it = hashSet.iterator();
							while(it.hasNext())
							{
								Student student = it.next();
								System.out.println(student);
							}
						}
						else
						{
							System.out.println("존재하지 않는 학번입니다.");
						}
						break;
					case 2:
						System.out.print("검색하실 학번을 입력하십시오  >>  ");
						int no = sc.nextInt();
						Student student1 = QueryClass.selectQueryStudentWhereNo(no);
						if(student1 != null)
						{
							System.out.println(student1);
						}
						else
						{
							System.out.println("존재하지 않는 이름입니다.");
						}
						flag = true;
						break;
					case 3: flag = true;
						break;
					default: System.out.println(".");
						break;
				}
			
			}//while
		}//try
		catch(Exception e)
		{
			System.out.println("검색부분 " + e.toString());
		}
		
	}
	private static void deleteData() throws Exception {
		try {
			System.out.println("삭제할 학생의 학번을 입력하십시오  >>  "); 
			int no = sc.nextInt();
			
			boolean returnValue = QueryClass.deleteQueryWhereNO(no); 
			if(returnValue ==true) 
			{ 
				System.out.println("삭제 완료. 종료");
			} 
		}
		catch(ClassNotFoundException e) 
		{
			 e.printStackTrace();
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	private static void insertData() throws Exception {
		boolean flag = false;
		Student student = null;
		Student insertStudent = null;
		int no;
		while(!flag)
		{
			System.out.print("추가할 인원의 학번을 적으십시오   >>   ");
			try
			{
				no = sc.nextInt();
				student = QueryClass.selectQueryStudentWhereNo(no);
				if(student != null && student.getStuNo() == no)
				{
					System.out.println("이미 존재하는 학번입니다.");
					continue;
				}//if
				System.out.print("이름을 입력하십시오  >>  ");
				String stuName = sc.next();
				System.out.print(stuName + "님의 아이디를 입력하십시오  >>  ");
				String id = sc.next();
				System.out.print(stuName + "님의 이메일을 입력하십시오  >>  ");
				String stuEmail = sc.next();
				System.out.print(stuName + "님의 나이를 입력하십시오  >>  ");
				int age = sc.nextInt();
				System.out.print(stuName + "님의 주소를 입력하십시오(ex.경기도 안양시)  >>  ");
				String address = sc.next();
				System.out.print(stuName + "님의 휴대폰 번호를 입력하십시오  >>  ");
				String stuPhone = sc.next();
				flag = true;
			}//try
			catch(Exception e)
			{
				System.out.println("입력이 비정상적으로 종료되었습니다.");
			}
		}//while
		boolean returnValue = QueryClass.insertQueryStudentInfo(insertStudent);
		if(returnValue == true)
		{
			System.out.println("완료");
		}
		else
		{
			System.out.println("실패");
		}
		
	}//insert
	private static void printData() throws Exception {
		HashSet<Student> hs = new HashSet<Student>();
		
		System.out.print("1)점수용   2)개인정보");
		int num = sc.nextInt();
		switch(num)
		{
			case 1 :
				hs = (HashSet<Student>) QueryClass.selectQueryStudent();
				if(hs != null)
				{
					Iterator<Student> it = hs.iterator();
					while(it.hasNext())
					{
						Student student = it.next();
						System.out.println(student);
					}
				}//if
				else
				{
					System.out.println("목록이 비어있습니다.");
				}//else
			break;
			case 2 :
				hs = (HashSet<Student>) QueryClass.selectNumQueryStudent();
				if(hs != null)
				{
					Iterator<Student> it = hs.iterator();
					while(it.hasNext())
					{
						Student student = it.next();
						System.out.println(student);
					}
				}//if
				else
				{
					System.out.println("목록이 비어있습니다.");
				}//else
			break;
			default : System.out.println("잘못된 입력값입니다.");
		
		
		
		}
		
		hs = (HashSet<Student>) QueryClass.selectQueryStudent();
		if(hs != null)
		{
			Iterator<Student> it = hs.iterator();
			while(it.hasNext())
			{
				Student student = it.next();
				System.out.println(student);
			}
		}//if
		else
		{
			System.out.println("목록이 비어있습니다.");
		}//else
		
	}

}//end









































