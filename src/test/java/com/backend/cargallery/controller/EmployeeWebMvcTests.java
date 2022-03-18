package com.backend.cargallery.controller;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@WithMockUser(username = "admin1234" ,password = "123" , authorities = "user")
public class EmployeeWebMvcTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testEmployee() throws Exception{
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/employee");
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		MatcherAssert.assertThat(mav.getViewName(), Matchers.equalTo("employee"));
		MatcherAssert.assertThat(mav.getModel().containsKey("employee"), Matchers.is(true));
	}
}
