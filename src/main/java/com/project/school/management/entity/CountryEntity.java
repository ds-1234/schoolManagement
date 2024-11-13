package com.project.school.management.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "countries")
public class CountryEntity {
	
	@Id
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "iso3")
	private String iso3;
	
	@Column(name = "numeric_code")
	private String numericCode;
	
	@Column(name = "iso2")
	private String iso2;
	
	@Column(name = "phone_code")
	private String phoneCode;
	
	@Column(name = "capital")
	private String capital;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "currency_name")
	private String currencyName;
	
	@Column(name = "currency_symbol")
	private String currencySymbol;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "region_id")
	private Long regionId;
	
	@Column(name = "subregion")
	private String subregion;
	
	@Column(name = "subregion_id")
	private Long subregionId;
	
	@Column(name = "nationality")
	private String nationality;
	

}
