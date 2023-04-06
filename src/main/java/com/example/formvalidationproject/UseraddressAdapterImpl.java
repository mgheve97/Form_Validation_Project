package com.example.formvalidationproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.formvalidationproject.util.Iuseraddress;
import com.example.formvalidationproject.util.useraddress;

@Component
public class UseraddressAdapterImpl implements UseraddressProperties{
	
	@Bean
	UseraddressAdapterImpl userAdapter2() {
		return new UseraddressAdapterImpl();
	}
	
	@Autowired
	private Iuseraddress getuseraddress;
	
	@Autowired
	private Iuseraddress setuseraddress;
	
	@Override
	public Iterable<useraddress> getuseraddress() {
		return getuseraddress.findAll();
	}
	
	@Override
	public void setuseraddress(String countries, String houseno, String street, String baranggay, String city, String province, String zipcode) {
		useraddress useradd = new useraddress(countries, houseno, street, baranggay, city, province, zipcode);
		setuseraddress.save(useradd);
	}

}
