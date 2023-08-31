package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional //rollback을 자동으로 하기 때문에 영속성 컨텍스트에서만 비교하고 db 들어가지 않음 -> insert 쿼리문 생성x
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    //@Autowired EntityManager em; //insert 쿼리문을 꼭 봐야한다면 em을 사용해서 flush 이용

    @Test
    //@Rollback(false) //롤백 안하기 때문에 db에 접근함 -> insert 쿼리문 생성
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("kim");
        member.setAddress(new Address("city", "street", "100"));

        //when
        Long savedId = memberService.join(member);

        //then
        //em.flush(); //강제 db 접근 이때는 db에 값이 들어가진 않음
        assertThat(member).isEqualTo(memberRepository.findOne(savedId));
    }

    @Test
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        try {
            memberService.join(member2);
        }catch (IllegalStateException e){
            return;
        }

        //then
        fail();
    }
}