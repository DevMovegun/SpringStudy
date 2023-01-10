package studySpring.helloSpring.repository;

import studySpring.helloSpring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// <T, pk 식별자>
// interface 끼리 받을 때는 extends
// interface는 다중 상속이 됨
// 스프링 데이터 JPA가 SpringDataJpaMemberRepository를 스프링 빈으로 자동으로 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
    //JPQL select m form Member m where m.name = ? 으로 자동으로 JPA가 만듦
    //규칙 Optional<Member> findByXXXANDYYY

    /*
    * findByName을 제외한 나머지 service는 기본적으로 스프링 데이터 JPA가 제공하므로 만들지 않아도 됨
    * 자세한건 강의자료 스프링 데이터 JPA 부분 참조
    * */
}
