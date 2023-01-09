package studySpring.helloSpring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import studySpring.helloSpring.domain.Member;
import studySpring.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createdForm() {
        return "members/createMemberForm"; // templates/members/createMemberForm.html 파일로 이동
    }

    @PostMapping("members/new") // createMembereForm.html에서 등록버튼을 누르면 여기로 넘어옴
    public String create(MemberForm form) { // 이전 html파일에서 넘어온 name값이 MemberForm 객체인 form.name에 저장됨
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member); // 회원 등록 서비스

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    // 2023.01.10 현재 MemoryRepository 밖에 없기 때문에 스프링 서버를 내리고 다시 시작하면 이전에 웹상에서 조작했던 모든 data가 날아간다
}
