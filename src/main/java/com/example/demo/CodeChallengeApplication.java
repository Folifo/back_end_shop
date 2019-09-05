package com.example.demo;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.ShopRepository;
import com.example.demo.entities.Shop;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class CodeChallengeApplication implements CommandLineRunner {

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Shop.class);
		for(int i=0;i<12;i++){
			Shop p = new Shop();
			p.setName(RandomString.make(5));
			p.setDistance(ThreadLocalRandom.current().nextDouble(0, 6));
			shopRepository.save(p);
		}
		
		
		
	}

}
