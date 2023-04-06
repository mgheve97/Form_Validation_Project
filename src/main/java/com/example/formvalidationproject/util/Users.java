package com.example.formvalidationproject.util;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer user_id;
	
	@Column(name="fname")
	private String first_name;
	
	@Column(name="mname")
	private String middle_name;
	
	@Column(name="lname")
	private String last_name;
	
	@Column(name="suffix")
	private String Suf_fix;
	
	@Column(name="gender")
	private String Gender;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="pnum")
	private String phone_num;
	
	@Column(name="emailadd")
	private String email_add;

	public Integer getUser_id() {
		return user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getSuf_fix() {
		return Suf_fix;
	}
	
	public String getgender() {
		return Gender;
	}

	public Integer getAge() {
		return age;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public String getEmail_add() {
		return email_add;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setSuf_fix(String suf_fix) {
		this.Suf_fix = suf_fix;
	}
	
	public void setgender(String Gender) {
		this.Gender = Gender;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public void setEmail_add(String email_add) {
		this.email_add = email_add;
	}
	
	

	public Users(String first_name, String middle_name, String last_name, String suf_fix, String Gender, Integer age,
			String phone_num, String email_add) {
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.Suf_fix = suf_fix;
		this.Gender = Gender;
		this.age = age;
		this.phone_num = phone_num;
		this.email_add = email_add;
	}
	
	public Users() {
		
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", Suf_fix=" + Suf_fix + ",  \", Gender=\" + Gender + \",age=" + age + ", phone_num=" + phone_num
				+ ", email_add=" + email_add + "]";
	}
	
	
}
