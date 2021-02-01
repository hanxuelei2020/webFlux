package com.hasut.webflux.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hasut.webflux.entity.User;
import com.hasut.webflux.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

	@Autowired
	private UserService userService;

	public UserHandler() {
		// TODO Auto-generated constructor stub
	}

	public UserHandler(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//id查询
	public Mono<ServerResponse> getUserById(ServerRequest request){
		String id = request.pathVariable("id");
		Mono<ServerResponse> build = ServerResponse.notFound().build();
		Integer UserId = Integer.valueOf(id);
		Mono<User> monoUser = userService.getUserById(UserId);
		return monoUser.flatMap(users->
						ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.bodyValue(users))
						.switchIfEmpty(build);
		
//		repository.getPerson(personId)
//        .flatMap(person -> ok().contentType(APPLICATION_JSON).bodyValue(person))
//        .switchIfEmpty(ServerResponse.notFound().build());
	}
	//查询所有
//	ok().contentType(APPLICATION_JSON).body(people, Person.class);
	public Mono<ServerResponse> showUsers(ServerRequest request){
		Flux<User> user = userService.getAllUser();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(user, User.class);
	}
	//添加
	public Mono<ServerResponse> saveUser(ServerRequest request){
		Mono<User> mono = request.bodyToMono(User.class);
		return ServerResponse.ok().build(this.userService.saveUserInfo(mono));
	}
}
