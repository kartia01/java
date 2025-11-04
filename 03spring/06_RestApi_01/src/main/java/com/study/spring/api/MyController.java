package com.study.spring.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/hello/world")
	public String helloworld() {
		return "hello Spring";
	}

	@PostMapping("/hello/world")
	public String postHelloworld() {
		return "[post] hello Spring";
	}

	@PutMapping("/hello/world")
	public String putHelloworld() {
		return "[put] hello spring";
	}

	@DeleteMapping("/hello/world")
	public String deleteHelloworld() {
		return "[delete] hello spring";
	}

	// localhost:808/test/param?name= &age=
	@GetMapping("/test/param")
	public String requestParam(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		return "hello, request : " + name + ", " + age;
	}

	// localhost:8080/test/param/홍길동/20
	@GetMapping("/test/path/{name}/{age}")
	public String requestPath(@PathVariable("name") String name, @PathVariable("age") String age) {
		return "hello, request : " + name + ", " + age;
	}

	@PostMapping("/test/body")
	public String requestBody(@RequestBody TestDto request) {
		return "hello, request : " + request.name + ", " + request.age + ", " + request.addr + ", " + request.hobby;
	}
}
