package com.hasut.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hasut.webflux.entity.User;
import com.hasut.webflux.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//id查询
	@GetMapping("/user/{id}")
	public Mono<User> getUserById(@PathVariable Integer id){
		return userService.getUserById(id);
	}
	//查询所有
	@GetMapping("/user")
	public Flux<User> showUsers(){
		return userService.getAllUser();
	}
	//添加
	@PostMapping("/saveuser")
	public Mono<Void> saveUser(@RequestBody User user){
		Mono<User> userMono = Mono.just(user);
		return userService.saveUserInfo(userMono);
	}
}
