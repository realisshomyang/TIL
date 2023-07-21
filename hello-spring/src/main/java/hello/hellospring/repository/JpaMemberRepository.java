package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    private final EntityManager em;
    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
    @Override
    public List<Member> findAll() {
        return (List<Member>) em.createQuery("select m from Member m", Member.class).getResultList();
        /*
        ctrl T
        sql이면 멤버 객체 자체를 찾는거임 이미 매핑을 되어 있고
         */
    }
}
