package com.hasut.webflux.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasut.webflux.entity.User;
import com.hasut.webflux.mapper.UserMapper;
import com.hasut.webflux.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	public Mono<User> getUserById(Integer id) {
		// TODO Auto-generated method stub
		User user = userMapper.selectById(id);
		return Mono.justOrEmpty(user);
	}

	@Override
	public Flux<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> list = userMapper.selectList(null);
		return Flux.fromIterable(list);
	}

	@Override
	public Mono<Void> saveUserInfo(Mono<User> user) {
		// TODO Auto-generated method stub
		return user.doOnNext(users->{
			userMapper.insert(users);
		}).thenEmpty(Mono.empty());
	}

	

}
