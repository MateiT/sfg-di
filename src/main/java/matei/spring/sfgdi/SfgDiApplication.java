package matei.spring.sfgdi;

import matei.spring.sfgdi.Controllers.*;
import matei.spring.sfgdi.Controllers.PetController;
import matei.spring.sfgdi.config.ConstructorConfig;
import matei.spring.sfgdi.config.MyConfiguration;
import matei.spring.sfgdi.datasource.FakeDatasource;
import matei.spring.sfgdi.services.PrototypeBean;
import matei.spring.sfgdi.services.SingeltonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"com.springframework.pets", "matei.spring.sfgdi"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("___Pets___");

		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("___I18n___");

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println("___Primary bean___");
		System.out.println(myController.sayhello());

		System.out.println("____Propriety____");
		ProprietyInjectedController proprietyInjectedController =
				(ProprietyInjectedController) ctx.getBean("proprietyInjectedController");
		System.out.println(proprietyInjectedController.getGreeting());

		System.out.println("____Setter____");
		SetterInjectedController setterInjectedController =
				(SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("____Constructor____");
		ConstructorInjectedController constructorInjectedController =
				(ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("____Beans____");
		SingeltonBean singeltonBean = ctx.getBean(SingeltonBean.class);
		System.out.println(singeltonBean.getMyScope());
		SingeltonBean singeltonBean1 =ctx.getBean(SingeltonBean.class);
		System.out.println(singeltonBean1.getMyScope());

		PrototypeBean prototypeBean = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean.getMyScope());
		PrototypeBean prototypeBean1 =ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());

		FakeDatasource fakeDatasource = ctx.getBean(FakeDatasource.class);
		System.out.println(fakeDatasource.getUsername());
		System.out.println(fakeDatasource.getPassword());
		System.out.println(fakeDatasource.getJdbcurl());

		System.out.println("_____Config props bean_____");
		MyConfiguration myConfiguration = ctx.getBean(MyConfiguration.class);
		System.out.println(myConfiguration.getUsername());
		System.out.println(myConfiguration.getPassword());
		System.out.println(myConfiguration.getJdbcurl());

		System.out.println("____Constructor Binding_____");
		ConstructorConfig config = ctx.getBean(ConstructorConfig.class);
		System.out.println(config.getUsername());
		System.out.println(config.getPassword());
		System.out.println(config.getJdbcurl());

	}

}
