package matei.spring.sfgdi.Controllers;

import matei.spring.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayhello(){
        return greetingService.sayGreeting();
    }
}
