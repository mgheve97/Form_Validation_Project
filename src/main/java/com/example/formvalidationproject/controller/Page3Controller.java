package com.example.formvalidationproject.controller;

import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.formvalidationproject.datamodels.addressdatamodels;
import com.example.formvalidationproject.datamodels.personaldatamodel;

import javafx.fxml.*;

public class Page3Controller implements Initializable{
	
	String firstname, lastname, middlename, sufx, gender_type, phonenumber, email_add,
	countryname, housenumber, streetname, brgytype, cityname,provincename,zipcodenum;
	Integer age_number;
	
	@FXML
	public Label first_name, middle_name, last_name, suffix, age, gender, phone_number, email_address,
	country, house_number, street, brgy, city, province, zipcode;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	public void personalvariables(personaldatamodel datamodel1) {
		this.firstname = datamodel1.getFirstname();
		this.middlename = datamodel1.getMiddlename();
		this.lastname = datamodel1.getLastname();
		this.sufx = datamodel1.getSuffix();
		this.gender_type = datamodel1.getGender();
		this.age_number = datamodel1.getAge();
		this.phonenumber = datamodel1.getPhonenumber();
		this.email_add = datamodel1.getEmailaddress();
		
		first_name.setText(this.firstname);
		middle_name.setText(this.middlename);
		last_name.setText(this.lastname);
		suffix.setText(this.sufx);
		age.setText(String.valueOf(this.age_number));
		phone_number.setText(this.phonenumber);
		email_address.setText(this.email_add);   
	}
	
	public void addressvariables(addressdatamodels datamodel2) {
		this.countryname = datamodel2.getCountry();
	    this.housenumber = datamodel2.getHousenumber();
	    this.streetname = datamodel2.getStreetnumber();
	    this.brgytype = datamodel2.getBrgyarea();
	    this.cityname= datamodel2.getCityname();
	    this.provincename = datamodel2.getProvincename();
	    this.zipcodenum = datamodel2.getZipcode();
	}
	
	public void submitbtn() {
		System.out.println(firstname);
		System.out.println(middlename);
		System.out.println(lastname);
		System.out.println(sufx);
		System.out.println(gender_type);
		System.out.println(age_number);
		System.out.println(phonenumber);
		System.out.println(email_add);
		System.out.println(countryname);
		System.out.println(housenumber);
		System.out.println(streetname);
		System.out.println(brgytype);
		System.out.println(cityname);
		System.out.println(provincename);
		System.out.println(zipcodenum);
	}
}
