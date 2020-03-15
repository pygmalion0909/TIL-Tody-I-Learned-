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

  @Test
  @Transactional 
  public void TestMember() throws Exception{
    Member member = new Member();

    member.setUsername("memberA");

    Long savedId = memeberRepository.save(member);

    Member findMember = memeberRepository.find(savedId);
    
    Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
    Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
  
  }
}