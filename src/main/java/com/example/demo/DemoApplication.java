package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.script.*;
import org.openjdk.nashorn.api.scripting.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) throws ScriptException {

		NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
		ScriptEngine engine = factory.getScriptEngine();
		engine.eval("print('Hello, World!');");

		return String.format("Hello %s!", name);
	}
}
