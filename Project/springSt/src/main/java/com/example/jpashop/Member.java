package com.example.jpashop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

// 이 파일의 정보를 jpa로 넘겨서 jpa가 db에 넘기네
@Entity
@Getter @Setter
public class Member {

	@Id @GeneratedValue
	private Long id;
	private String username;
	
	
	
	
	
}
