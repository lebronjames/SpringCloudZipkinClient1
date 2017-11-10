package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class SpringCloudZipkinClient1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinClient1Application.class, args);
	}
	
	@Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    @RequestMapping("/hi")
    public String callHome(){
    	System.out.println("calling miya trace service-hi:info diao Miya");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }
    @RequestMapping("/info")
    public String info(){
        System.out.println("calling trace service-hi ");
        return "i'm service-hi";

    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
