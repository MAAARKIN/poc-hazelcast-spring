package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EchoService {
	private static Logger log = LoggerFactory.getLogger(EchoService.class);

	@Cacheable(value="echo")
	public String cacheavel() {
		log.info("executing method cacheavel");
		return "Teste";
	}
	
	@CacheEvict(allEntries = true, value="echo")
	public void clear() {
		
	}
}
