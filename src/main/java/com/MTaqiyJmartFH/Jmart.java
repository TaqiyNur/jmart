package com.MTaqiyJmartFH;



import com.MTaqiyJmartFH.dbjson.JsonDBEngine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Jmart Class
 *
 * @author Muhammad Taqiy Nur Furqon
 */
@SpringBootApplication
public class Jmart {
	public static void main(String[] args) {
		JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join())); 
	}
}