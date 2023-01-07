package studySpring.helloSpring.repository;

import studySpring.helloSpring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); // 회원 등록

    //Optional<>를 쓰는 이유 가져오는게 null 일 수 있어 감싸기 위해서
    Optional<Member> findById(Long id); // 회원 조회
    Optional<Member> findByName(String name); // 회원 조회
    List<Member> findAll(); // 모든 회원 리스트 조회
}
