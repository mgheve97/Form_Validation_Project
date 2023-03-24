package com.example.formvalidationproject.util;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country-codes")
public class countrycode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="International dialing")
	private String pnum;

	@Override
	public String toString() {
		return "countrycode [pnum=" + pnum + "]";
	}
}
