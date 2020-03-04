package com.demo.mobilestore.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.mobilestore.dao.ICategoryDao;
import com.demo.mobilestore.dao.IMobileDao;

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
	public void givenMobileData_addMobile() {
		
		
	}

}
