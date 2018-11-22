package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import whenDoc.whenDOc.WhenDOcApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WhenDOcApplication.class)
@TestPropertySource(locations="classpath:application.properties")
public class WhemDocBackEndApplicationTests {

	@Test	
	public void contextLoads() {	
	}

}
