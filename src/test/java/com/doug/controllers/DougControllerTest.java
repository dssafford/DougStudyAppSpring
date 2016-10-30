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
public class DougControllerTest {
	private MockMvc mockMvc;

	private DougController dougController;

	@Before
	public void setup(){
		dougController = new DougController();

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/templates");

		mockMvc = MockMvcBuilders.standaloneSetup(dougController)
				  .setViewResolvers(viewResolver)
				  .build();
	}

	@Test
	public void testIndex() throws Exception{
		mockMvc.perform(get("/doug"))
				  .andExpect(status().isOk())
				  .andExpect(view().name("doug"));
	}


}
