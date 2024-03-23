package org.opd.module;

public class PatientModule {
   @Override
	public String toString() {
		return "PatientModule [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", address="
				+ address + ", age=" + age + ", gender=" + gender + ", diesese=" + diesese + ", adhar=" + adhar
				+ ", username=" + username + ", password=" + password + "]";
	}

private int id;
   private String name;
   private String email;
   private String contact;
   private String address;
   private int age;
   private String gender;
   private String diesese;
   private String adhar;
   public String getDiesese() {
	return diesese;
}

public void setDiesese(String diesese) {
	this.diesese = diesese;
}

public String getAdhar() {
	return adhar;
}

public void setAdhar(String adhar) {
	this.adhar = adhar;
}

private String username;
   private String password;
//   private int DoctorId;

//public int getDoctorId() {
//	return DoctorId;
//}
//
//public void setDoctorId(int doctorId) {
//	DoctorId = doctorId;
//}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
