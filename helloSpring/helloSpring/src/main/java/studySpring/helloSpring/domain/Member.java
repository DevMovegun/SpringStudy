package studySpring.helloSpring.domain;

public class Member {

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
