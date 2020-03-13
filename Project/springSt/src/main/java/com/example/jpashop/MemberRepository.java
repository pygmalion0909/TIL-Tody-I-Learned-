package com.example.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
	
//	엔티티 매니저 지정 할때 사용?
	@PersistenceContext
	private EntityManager em;
	
	public Long save(Member member) {
		em.persist(member);
		return member.getId();
	}
	
//	Member가 Entity로 설정되어 있어서 JSP에 있는 find 메소드 사용가능?!
	public Member find(Long id) {
		return em.find(Member.class, id);
	}
	
}
