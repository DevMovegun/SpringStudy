package studySpring.helloSpring.controller;

import studySpring.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // @Controller를 쓰면 스프링이 시작할때 Controller 객체를 생성하여 들고 있음
// Controller는 수동으로 Bean 설정을 못함
public class MemberController {

    private final MemberService memberService;
    
    // DI에는 필드 주입, setter 주입, 생성자 주입 3가지 방법이 있다.

    // @Autowired private MemberService memberService; 1. 필드 주입 (권장되지 않는 방법)

    // @Autowired
    // public void setMemberService(MemberService memberService) {
    //      this.memberService = memberService;
    // } 2. setter 주입 단점은 public으로 노출되어 있으므로 문제를 얘기할 수 없음.

    @Autowired
    public MemberController(MemberService memberService) { // 생성자 주입 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 가장 권장되는 방법
        this.memberService = memberService;
    }

}
