package studySpring.helloSpring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import studySpring.helloSpring.domain.Member;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 테스트 메서드 하나가 실행되고 끝난 후 다음 테스트로 넘어가기 전에 무조건 @AfterEach 아래 메서드를 실행함
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {

        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // 1번째 테스트 확인 방법 System.out.println("result = " + (result == member));
        // 2번째 테스트 확인 방법
        assertThat(result).isEqualTo(member); // 통과 되면 초록색 불 안되면 에러남
    }

    @Test
    public void findByName() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
