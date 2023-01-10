package studySpring.helloSpring;

// 자바 코드로 직접 스프링빈 하는 방법
// 이유 현재 요구사항이 아직 DB가 정해지지 않은 경우라 후에 수정하기 편하기 위해 직접 수동으로 함
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studySpring.helloSpring.repository.JdbcTemplateMemberRepository;
import studySpring.helloSpring.repository.MemberRepository;
import studySpring.helloSpring.repository.MemoryMemberRepository;
import studySpring.helloSpring.repository.JdbcMemberRepository;
import studySpring.helloSpring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource); // memoryMemberRepository에서 JdbcMemberRepository로 한줄만 바꿔주면 수정할 필요가 없다
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
