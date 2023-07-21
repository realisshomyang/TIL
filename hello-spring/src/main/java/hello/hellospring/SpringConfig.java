package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    /*
    등록한게 없지 않나? 인터페이스에 대한 구현체를 스프링 데이터 JPA가 해준다
     */
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    /*
        private DataSource dataSource;
        @Autowired
        public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }*/

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
    //@Bean
    //public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JdbcMemberRepository();
      //  return new JpaMemberRepository(em);
    //}

}
