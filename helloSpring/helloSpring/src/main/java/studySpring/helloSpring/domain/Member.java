package studySpring.helloSpring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // jpa 는 객체랑 ORM(Object Relational Mapping)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // sequence같이 DB가 알아서 생성해주는것
    private Long id;
    private String name;

    // getter setter 인텔리제이 단축키 => Alt+Insert
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
