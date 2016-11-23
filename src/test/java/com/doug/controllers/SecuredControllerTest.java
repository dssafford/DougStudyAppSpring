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
public class SecuredControllerTest {
	private MockMvc mockMvc;

	private SecuredController securedController;

	@Before
	public void setup(){
		securedController = new SecuredController();
		//mockMvc = MockMvcBuilders.standaloneSetup(securedController).build();
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/templates");

		mockMvc = MockMvcBuilders.standaloneSetup(securedController)
				  .setViewResolvers(viewResolver)
				  .build();
	}

	@Test
	public void testSecuredTemplate() throws Exception{
		mockMvc.perform(get("/secured"))
				  .andExpect(status().isOk())
				  .andExpect(view().name("secured"));
	}
}
