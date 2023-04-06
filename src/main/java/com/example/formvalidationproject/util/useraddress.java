package com.example.formvalidationproject.util;

import jakarta.persistence.*;


@Entity
@Table(name = "useraddress")
public class useraddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="useradd_id")
	private Integer useradd_id;
	
	@Column(name="countries")
	private String countries;
	
	@Column(name="houseno")
	private String houseno;
	
	@Column(name="street")
	private String street;
	
	@Column(name="baranggay")
	private String baranggay;
	
	@Column(name="city")
	private String city;
	
	@Column(name="province")
	private String province;
	
	@Column(name="zipcode")
	private String zipcode;

	public Integer getUseradd_id() {
		return useradd_id;
	}

	public String getCountries() {
		return countries;
	}

	public String getHouseno() {
		return houseno;
	}

	public String getStreet() {
		return street;
	}

	public String getBaranggay() {
		return baranggay;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setUseradd_id(Integer useradd_id) {
		this.useradd_id = useradd_id;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setBaranggay(String baranggay) {
		this.baranggay = baranggay;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

	public useraddress(String countries, String houseno, String street, String baranggay, String city, String province,
			String zipcode) {
		this.countries = countries;
		this.houseno = houseno;
		this.street = street;
		this.baranggay = baranggay;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
	}
	
	public useraddress() {
		
	}

	@Override
	public String toString() {
		return "useraddress [useradd_id=" + useradd_id + ", countries=" + countries + ", houseno=" + houseno
				+ ", street=" + street + ", baranggay=" + baranggay + ", city=" + city + ", province=" + province
				+ ", zipcode=" + zipcode + "]";
	}

	
	
	
}


