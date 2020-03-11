package com.demo.mobilestore.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.mobilestore.dao.ICategoryDao;
import com.demo.mobilestore.dao.IMobileDao;
import com.demo.mobilestore.model.Mobile;

@RunWith(SpringRunner.class)
@WebMvcTest(MobileController.class)
class MobileControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	IMobileDao iMobileDao;

	@MockBean
	ICategoryDao categoryDao;

	@Test
	public void givenMobileData_addMobile() throws Exception {

		Mobile mobile = new Mobile();
		mobile.setMobileBrand("OPPO");
		mobile.setMobileId(8);
		mobile.setMobileModel("very");

		when(iMobileDao.save(mobile)).thenReturn(mobile);

		mvc.perform(get("/mobile").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("OPPO", is(mobile.getMobileBrand())));

	}

}
