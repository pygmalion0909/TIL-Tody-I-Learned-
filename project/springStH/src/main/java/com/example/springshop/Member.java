package com.example.springshop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// 엔티티 항목들!
// 여기내용이 db에 테이블, 컬럼이 된다.

// Entity라고 선언해야 엔티티 매니저가 관리 들어감.
@Entity

// class명이 테이블 명 되는 것 같은데....
public class Member{

  @Id @GeneratedValue
  private Long Id;
  private String username;

  public Long getId() {
  	return this.Id;
  }
  public void setId(Long Id) {
  	this.Id = Id;
  }

  public String getUsername() {
  	return this.username;
  }
  public void setUsername(String username) {
  	this.username = username;
  }

}