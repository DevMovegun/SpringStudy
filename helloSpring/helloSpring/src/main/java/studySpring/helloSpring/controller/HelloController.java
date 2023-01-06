package studySpring.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 기본동작 실습
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    //MVC 실습
    @GetMapping("helloMVC")
    public String helloMVC(@RequestParam("name") String name, Model model) { //../helloMVC 뒤에 ?name=xxx로 파라미터를 넘겨야 오류가 안남.
        model.addAttribute("name", name); //웹브라우저에서 파라미터로 넘어온 "name"을 name 변수에 저장
        return "helloTemplate";
    }

    // API 실습
    @GetMapping("helloString")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("helloApi")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체를 넘기면 {"key" : "value"} 값인 JSON 방식으로 넘어가게됨.
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
