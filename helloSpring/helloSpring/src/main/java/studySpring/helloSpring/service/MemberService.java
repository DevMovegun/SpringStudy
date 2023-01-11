package studySpring.helloSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studySpring.helloSpring.domain.Member;
import studySpring.helloSpring.repository.MemberRepository;
import studySpring.helloSpring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// @Service 자동으로 스프링이 등록해줌
@Transactional // jpa는 모든 data 변경이 transaction 안에서 실행되어야 함
public class MemberService { // class 내에서 Ctrl+Shift+T를 누르면 자동으로 테스트 케이스를 만들어줌
    private final MemberRepository memberRepository;

    // @Autowired 자동으로 스프링이 등록해줌
    public MemberService(MemberRepository memberRepository) { // class 내에서 new 객체를 생성하지 않고 외부에서 받음 => Dependency Injection
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member) {

        // 직접 했을 때
        // 공통 관심사항(cross-cutting concern)인 시간을 측정하는 로직을 위해 코드가 복잡해져서
        // 핵심 관심사항(core concern)인 join service 로직에 유지보수가 어려워짐
        /* long start = System.currentTimeMillis();

        try {
            validateDuplicateMember(member); // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        } */

        // AOP 적용 후
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

        /* AOP 적용 전
        long start = System.currentTimeMillis();

        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers = " + timeMs + "ms");
        } */

        // AOP 적용 후
        return memberRepository.findAll();

    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}