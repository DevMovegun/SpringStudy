package studySpring.helloSpring.service;

import studySpring.helloSpring.domain.Member;
import studySpring.helloSpring.repository.MemoryMemberRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test // test는 과감하게 한글로 이름 지어도 됨. 빌드 될 때 테스트 코드는 포함되지 않음.
    void 회원가입() { // 테스트는 무언가 주어지고(given) 뭔가를 실행했을 때(when) 이 결과가 나와야함 (then)
        //given
        Member member = new Member();
        member.setName("Spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복회원예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("Spring");
        Member member2 = new Member();
        member2.setName("Spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}