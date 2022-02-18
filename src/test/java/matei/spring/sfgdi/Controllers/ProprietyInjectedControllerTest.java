package matei.spring.sfgdi.Controllers;

import matei.spring.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProprietyInjectedControllerTest {
    ProprietyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ProprietyInjectedController();

        controller.greetingService = new ConstructorGreetingService();
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}