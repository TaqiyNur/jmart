package com.MTaqiyJmartFH;



import com.MTaqiyJmartFH.dbjson.JsonDBEngine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kelas utama Jmart
 *
 * @author mtaqi
 */
@SpringBootApplication
public class Jmart {
	public static void main(String[] args) {
		JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join())); 
	}
}