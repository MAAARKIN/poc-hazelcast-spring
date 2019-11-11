package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
public class DemoApplication {
	
	@Autowired
    private EchoService echoService;
	
	private static Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@GetMapping(path="/info", produces = "application/json")
	public Pessoa info() {
		Pessoa p = new Pessoa();
		p.setNome("markin v2");
		
		System.out.println("chamando o cacheavel");
		echo();
		return p;
	}
	
	@GetMapping(path="/clear", produces = "application/json")
	public void clear() {
		echoService.clear();
	}
	
	private void echo() {
		log.info("Calling: cacheavel)");
		echoService.cacheavel();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
