package com.dev.neo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dev.neo.ApiServiceApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiServiceApplication.class)
@WebAppConfiguration
public class ApiServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
