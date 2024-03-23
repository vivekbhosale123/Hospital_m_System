package org.opd.module;

public class DoctorModule {
	private String name;
	private String email;
	private String contact;
	private String address;
	private int exp;
	private String gender;
	private int age;
	private int did;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "DoctorModule [name=" + name + ", email=" + email + ", contact=" + contact + ", address=" + address
				+ ", exp=" + exp + ", gender=" + gender + ", age=" + age + ", did=" + did + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return did;
	}

	public void setId(int did) {
		this.did = did;
	}
}
