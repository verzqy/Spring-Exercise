package com.mitrais.train.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class EmployeeControllerTest {
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
	}

	@Test
	public void getEmployee() throws Exception {
		this.mockMvc.perform(get("/employees?gender=male")).andExpect(status().isOk());
	}

	@Test
	public void postEmployee() throws Exception {
		this.mockMvc.perform(post("/employees").content("{\"id\":\"1234\",\"name\":\"budi\",\"gender\":\"male\"}")
				.contentType("application/json"))
				.andExpect(status().isOk());

	}
}
