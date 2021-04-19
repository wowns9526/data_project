package portfolioProject;

import java.util.Objects;

public class Student {
	
	private int stuNo;
	private String stuName;
	private String id;;
	private String stuEmail;
	private int age;
	private String address;
	private String stuPhone;
	
	public Student(int stuNo, String stuName, String id, String stuEmail, int age, String address, String stuPhone) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.id = id;
		this.stuEmail = stuEmail;
		this.age = age;
		this.address = address;
		this.stuPhone = stuPhone;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	@Override
	public String toString() {
		return "\t" + stuNo + "\t" + stuName + "\t" + id + "\t" + stuEmail + "\t"
				+ age + "\t" + address + "\t" + stuPhone;
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(stuNo);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student)
		{
			Student student = (Student)obj;
			if(student.stuNo == this.stuNo)
				return true;
		}
		return false;
	}
	
	
	

}
