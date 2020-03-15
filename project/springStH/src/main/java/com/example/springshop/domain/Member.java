package com.example.springshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member{
  
  @Id @GeneratedValue
  @Column(name="member_id")
  private Long Id;
  private String name;

  // 어딘가에 내장 되어 있다 선언.
  @Embedded
  private Address address;
  private List<Order> orders = new ArrayList<>();

  public Long getId() {
  	return this.Id;
  }
  public void setId(Long Id) {
  	this.Id = Id;
  }


  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }


  public Address getAddress() {
    return this.address;
  }
  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Order> getOrders() {
  	return this.orders;
  }
  public void setOrders(List<Order> orders) {
  	this.orders = orders;
  }


}