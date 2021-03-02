package com.uda.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class DemoApplicationTests {
	


	@Autowired
	WebApplicationContext webApplicationContext;
	MockMvc mvc;
	protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	@Test
	void contextLoads() {
	}


	@Test
	public void getProductsList() throws Exception {
		setUp();
		String uri = "/hello";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.ALL_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		
		assertTrue(content.length() > 0);
	}

}
