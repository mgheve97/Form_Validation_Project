package com.example.formvalidationproject.datamodels;

public class personaldatamodel {
	public String firstname;
	public String middlename;
	public String lastname;
	public String suffix;
	public String gender;
	public Integer age;
	public String phonenumber;
	public String emailaddress;
	
	public String getFirstname() {
		return firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public String getSuffix() {
		return suffix;
	}
	public String getGender() {
		return gender;
	}
	public Integer getAge() {
		return age;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
}
