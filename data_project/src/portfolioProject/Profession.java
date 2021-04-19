package portfolioProject;

import java.util.Objects;

public class Profession {

	private int proNo;
	private String proName;
	private String proEmail;
	private String proSub;
	private String proPhone;
	
	public Profession(int proNo, String proName, String proEmail, String proSub, String proPhone) {
		super();
		this.proNo = proNo;
		this.proName = proName;
		this.proEmail = proEmail;
		this.proSub = proSub;
		this.proPhone = proPhone;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProEmail() {
		return proEmail;
	}

	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}

	public String getProSub() {
		return proSub;
	}

	public void setProSub(String proSub) {
		this.proSub = proSub;
	}

	public String getProPhone() {
		return proPhone;
	}

	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}

	@Override
	public String toString() {
		return "\t" + proNo + "\t" + proName + "\t" + proEmail + "\t" + proSub
				+ "\t" + proPhone;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(proNo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Profession)
		{
			Profession profession = (Profession)obj;
			if(profession.proNo == this.proNo)
				return true;
		}
		return super.equals(obj);
	}

}
