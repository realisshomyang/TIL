package hello.hellospring.domain;

import javax.persistence.*;

/*
jdbc 쓰려면 엔티티 매핑을 해야함
jpa 표준 인터페이스 구현은 업체마다 하는건데 하이버네티스꺼 쓴다.
jpa Orm object relational data table mapping
 */
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
