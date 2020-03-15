package com.example.springshop.domain;

import javax.persistence.Embeddable;

// 어딘가에 내장이 될 수 있다 선언.
@Embeddable
public class Address {

  private String city;
  private String street;
  private String zipcode;

  public String getCity() {
  	return this.city;
  }

  public String getStreet() {
  	return this.street;
  }

  public String getZipcode() {
  	return this.zipcode;
  }

}
