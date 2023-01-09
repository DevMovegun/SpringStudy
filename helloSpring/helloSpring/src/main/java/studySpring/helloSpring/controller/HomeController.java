package studySpring.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/") // 그냥 / 하나는 localhost:8080을 입력하면 뜨는 홈
    public String home() {
        return "home";
    }
}
