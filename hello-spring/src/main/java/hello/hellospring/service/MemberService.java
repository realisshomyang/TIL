package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepsitory;
import hello.hellospring.repository.MemoryMemberRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepsitory memberRepsitory;
    public MemberService(MemberRepsitory memberRepsitory) {
        this.memberRepsitory = memberRepsitory;
    }

    /*
    * 회원 가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복회원 X
        validateDuplicateMember(member);
        memberRepsitory.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepsitory.findByName(member.getName())
                .ifPresent(m->{throw new IllegalStateException("이미 존재하지 회원입니다.");});
    }
    /*
    전체 회원 조회
    네이밍이 비즈니스에 관련된
     */
    public List<Member> findMembers(){
        return memberRepsitory.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepsitory.findById(memberId);
    }
}
