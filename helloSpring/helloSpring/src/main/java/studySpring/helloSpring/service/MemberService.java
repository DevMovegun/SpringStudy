package studySpring.helloSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studySpring.helloSpring.domain.Member;
import studySpring.helloSpring.repository.MemberRepository;
import studySpring.helloSpring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// @Service 자동으로 스프링이 등록해줌
public class MemberService { // class 내에서 Ctrl+Shift+T를 누르면 자동으로 테스트 케이스를 만들어줌
    private final MemberRepository memberRepository;

    // @Autowired 자동으로 스프링이 등록해줌
    public MemberService(MemberRepository memberRepository) { // class 내에서 new 객체를 생성하지 않고 외부에서 받음 => Dependency Injection
        this.memberRepository = memberRepository;
    }
    // 회원 가입
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}