package ru.vsu.cs.testPrjct.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vsu.cs.testPrjct.demo.Service.UserService;

import java.io.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		var context = SpringApplication.run(DemoApplication.class, args);

    }
}
