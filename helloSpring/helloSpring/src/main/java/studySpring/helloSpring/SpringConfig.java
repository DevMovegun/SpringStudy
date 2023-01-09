package studySpring.helloSpring;

// 자바 코드로 직접 스프링빈 하는 방법
// 이유 현재 요구사항이 아직 DB가 정해지지 않은 경우라 후에 수정하기 편하기 위해 직접 수동으로 함
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studySpring.helloSpring.repository.MemberRepository;
import studySpring.helloSpring.repository.MemoryMemberRepository;
import studySpring.helloSpring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
