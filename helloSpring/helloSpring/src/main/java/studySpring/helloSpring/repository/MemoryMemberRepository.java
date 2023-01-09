package studySpring.helloSpring.repository;

import org.springframework.stereotype.Repository;
import studySpring.helloSpring.domain.Member;

import java.util.*;

// @Repository 자동으로 스프링이 등록해줌
public class MemoryMemberRepository implements MemberRepository { // Alt+Shift+Enter를 누르면 implements methods 할 수 있음

    private static Map<Long, Member> store = new HashMap<>(); // data를 저장할 변수
    private static long sequence = 0L; // 키 값을 생성해주는 변수

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // store.get(id)가 null일 경우 Optional.ofNullable()로 null도 감싸기가 가능함
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
