package ar.com.leandro.reporteria;

public class Person {
	
	private String name;
	private String birth;
	private String gender;
	
	public Person(String name, String date, String gender){
		this.name = name;
		this.birth = date;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getGender() {
		return gender;
	}
}
