package com.example.jpashop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

// �� ������ ������ jpa�� �Ѱܼ� jpa�� db�� �ѱ��
@Entity
@Getter @Setter
public class Member {

	@Id @GeneratedValue
	private Long id;
	private String username;
	
	
	
	
	
}
