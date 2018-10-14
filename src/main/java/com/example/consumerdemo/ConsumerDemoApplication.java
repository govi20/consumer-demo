package com.example.consumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableBinding(MyProcessor.class)
public class ConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDemoApplication.class, args);
	}
	
	@StreamListener(MyProcessor.INPUT)
	public void eventHandler(String message) {
		System.out.println("**************  Message received => "+message);
	}
}


@Component
interface MyProcessor {
    String INPUT = "myOutput";
 
    @Input("myOutput")
    SubscribableChannel anOutput();
}