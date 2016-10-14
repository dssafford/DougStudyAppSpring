package com.doug.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Doug on 10/13/16.
 */
public class LoginControllerTest {
	private MockMvc mockMvc;

	private LoginController loginController;

	@Before
	public void setup(){
		loginController = new LoginController();
//		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/templates");

		mockMvc = MockMvcBuilders.standaloneSetup(loginController)
				  .setViewResolvers(viewResolver)
				  .build();
	}

	@Test
	public void testIndex() throws Exception{
		mockMvc.perform(get("/login"))
				  .andExpect(status().isOk())
				  .andExpect(view().name("login"));
	}


}
