package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepsitory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepsitory memberRepository;
    //MemoryMemberRepsitory repository = new MemoryMemberRepsitory();
    //-> static이니까 그냥 써도 되는데, 다른 인스턴스인 경우 이 코드는 잘못 될 수 있음
    //이걸 해결하려면 생성자를 만들어준다., 멤버 서비스 입장에서 외부에서 생성한 객체를 넣어준다.
    //이를 dependency injection이라고 한다.
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepsitory();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    //할 때마다 클리어 해줘야한다.

    //한글로 이름 적어도됨 test는
    /*
    test는
    given
    when
    then
    으로 구성하는ㄱ 좋다.
     */
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //e로 받아서 검증도 가능하다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하지 회원입니다.");
        /*
        try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하지 회원입니다.");
        }*/
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}