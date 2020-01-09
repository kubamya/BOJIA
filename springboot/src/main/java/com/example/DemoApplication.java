package com.example;

import com.example.control.TcpServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.example.*.mapper")
public class DemoApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//		new TcpServer().receive();
    }
    
    @Override
	public void addCorsMappings(CorsRegistry registry) {
 
		registry.addMapping("/**")
				.allowCredentials(true)
				.allowedHeaders("*")
				.allowedOrigins("*")
				.allowedMethods("*");
	}
}
