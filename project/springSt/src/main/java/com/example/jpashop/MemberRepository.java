package com.example.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
	
//	��ƼƼ �Ŵ��� ���� �Ҷ� ���?
	@PersistenceContext
	private EntityManager em;
	
	public Long save(Member member) {
		em.persist(member);
		return member.getId();
	}
	
//	Member�� Entity�� �����Ǿ� �־ JSP�� �ִ� find �޼ҵ� ��밡��?!
	public Member find(Long id) {
		return em.find(Member.class, id);
	}
	
}
