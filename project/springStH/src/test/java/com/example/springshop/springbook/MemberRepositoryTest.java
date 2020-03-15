package com.example.springshop.springbook;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.springshop.Member;
import com.example.springshop.MemeberRepository;

@SpringBootTest
class MemberRepositoryTest {
  @Autowired MemeberRepository memeberRepository;

  @Test // 테스트를 하겠다는 선언?!
  @Transactional  // 엔티티의 데이터 변경은 모두 Transitional에서 이루어 져야한다.
  public void TestMember() throws Exception{
    Member member = new Member();

    member.setUsername("memberA");
    Long savedId = memeberRepository.save(member);

    Member findMember = memeberRepository.find(savedId);
    
    Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
    Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
  
  }
}