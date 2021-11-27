package ua.lviv.mavenJU.JA.lesson_02;

public class Users {
	private String firstName;
	private String lastName;
	private int age;
	public Users(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public Users(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Users [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


}

