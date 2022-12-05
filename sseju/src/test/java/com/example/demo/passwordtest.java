package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class passwordtest {
	@Test
	public void test() {
		  BCryptPasswordEncoder enco = new BCryptPasswordEncoder();
	      String pass = enco.encode("admin");
	      System.out.println(pass);
	      System.out.println(enco.matches("admin", pass));

	}
}
