package com.example.formvalidationproject;

import com.example.formvalidationproject.util.Users;

public interface UserProperties {
	
	Iterable<Users> getUsers();
	
	void setUsers(String first_name, String middle_name, String last_name, String Suf_fix, String gender, Integer age, String phone_num, String email_add);
}
