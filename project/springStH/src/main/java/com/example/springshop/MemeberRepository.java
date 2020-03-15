package com.example.springshop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

// 엔티티를 찾아주는 역할(dao랑 비슷한 것)

@Repository
public class MemeberRepository{
  
  // 엔티티 메니저를 불러주는 역할
  @PersistenceContext
  private EntityManager em;

  public Long save(Member member){
    em.persist(member);
    return member.getId();
  }

  public Member find(Long id){
    return em.find(Member.class, id);
  }
  
}