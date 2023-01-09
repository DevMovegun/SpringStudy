package studySpring.helloSpring.controller;

public class MemberForm {
    private String name; // createMemberForm.html로 넘어온 name이 setName을 통해 이 변수로 저장됨.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
