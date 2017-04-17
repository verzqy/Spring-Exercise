package com.mitrais.train.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class WebAppTest {
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders
				.standaloneSetup(new HelloController())
				.build();
	}
	
	@Test
	public void getMessage() throws Exception {
		this.mockMvc.perform(get("/hello"))
		.andExpect(status().isOk());
	}
}
