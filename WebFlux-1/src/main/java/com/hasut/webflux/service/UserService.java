package com.hasut.webflux.service;

import com.hasut.webflux.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
	//根据id查询用户
	Mono<User> getUserById(Integer id);
//	一个返回值用Mono，多个返回值用Flux
//	查询所有用户
	Flux<User> getAllUser();
	
//	添加用户
	Mono<Void> saveUserInfo(Mono<User> user);
}
