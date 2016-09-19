package com.doug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@SpringBootApplication
public class DougStudyAppSpringApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(DougStudyAppSpringApplication.class, args);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//get current date time with Date()
		Date date = new Date();
		System.out.println("DATE====================" + dateFormat.format(date));

		//get current date time with Calendar()
		Calendar cal = Calendar.getInstance();
		System.out.println("HEYYYYYY======================" + dateFormat.format(cal.getTime()));


	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addRedirectViewController("/", "/login");
//
//	}
}
