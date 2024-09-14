package com.dockerexample.dockertest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DockertestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void hmm(){
 		for(int i = 0 ; i <= 5 ; i++){
			System.out.println("Java");
			i--;
			i++;
		}
	}

}
