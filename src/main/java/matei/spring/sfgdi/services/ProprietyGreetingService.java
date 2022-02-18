package matei.spring.sfgdi.services;

import org.springframework.stereotype.Service;

public class ProprietyGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hellp word! - propriety";
    }
}
