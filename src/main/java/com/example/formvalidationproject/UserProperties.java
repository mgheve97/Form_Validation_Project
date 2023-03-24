package com.example.formvalidationproject;

import com.example.formvalidationproject.util.Users;
import com.example.formvalidationproject.util.countrycode;
import com.example.formvalidationproject.util.useraddress;

public interface UserProperties {
	
	Iterable<Users> getUsers();
	Iterable<useraddress> getuseraddress();
	Iterable<countrycode> getcountrycodes();
	
	void setUsers(String first_name, String middle_name, String last_name, String Suf_fix, String gender, Integer age, String phone_num, String email_add);
	void setuseradd(String countries, String houseno, String street, String baranggay, String city, String province, String zipcode);
	
	
}
