package com.example.formvalidationproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.example.formvalidationproject.util.*;

@Component
public class UsersAdapterImpl implements UserProperties{
	
	@Bean
	UsersAdapterImpl userAdapter() {
		return new UsersAdapterImpl();
	}
	
	@Autowired
	private IUsers getUsers;
	
	@Autowired
	private IUsers setUsers;

	@Override
	public Iterable<Users> getUsers() {
		return getUsers.findAll();
	}
	

	@Override
	public void setUsers(String first_name, String middle_name, String last_name, String Suf_fix, String Gender, Integer age, String phone_num, String email_add) {
		
		Users user = new Users(first_name, middle_name, last_name, Suf_fix, Gender, age, phone_num, email_add);
		setUsers.save(user);
	}
}
