package com.example.formvalidationproject;

import com.example.formvalidationproject.util.useraddress;

public interface UseraddressProperties {

	Iterable<useraddress> getuseraddress();
	
	void setuseraddress(String countries, String houseno, String street, String baranggay, String city, String province, String zipcode);
}
