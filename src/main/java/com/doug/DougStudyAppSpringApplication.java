package com.doug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DougStudyAppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DougStudyAppSpringApplication.class, args);

//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		//get current date time with Date()
//		Date date = new Date();
//		System.out.println("DATE ====================" + dateFormat.format(date));
//
//		//get current date time with Calendar()
//		Calendar cal = Calendar.getInstance();
//		System.out.println("HEYYYYYY ======================" + dateFormat.format(cal.getTime()));

	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addRedirectViewController("/", "/journalindex");
//	}


//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addRedirectViewController("/", "/login");
//
//	}
}
