package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장하면 저장된 회원 반환
    Optional<Member> findById(Long id); //id로 회원찾기
    Optional<Member> findByName(String name); //이름으로 회원찾기
    //Optional 파일 반환을 NULL을 Optional으로 감쌈.
    List<Member> findAll();

}
