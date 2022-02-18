package matei.spring.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingeltonBean {

    public SingeltonBean() {
        System.out.println("Creating a singelton bean!");
    }

    public String getMyScope(){
        return "I'm sa singelton!";
    }
}
