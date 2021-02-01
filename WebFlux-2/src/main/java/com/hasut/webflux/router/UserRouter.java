package com.hasut.webflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hasut.webflux.handler.UserHandler;
import com.hasut.webflux.service.impl.UserServiceImpl;

import reactor.netty.http.server.HttpServer;

@Configuration
public class UserRouter {

	@Autowired
	private UserHandler userHandler;
	@Bean
	public RouterFunction<ServerResponse> routerFunction(){
//		UserServiceImpl userServiceImpl = new UserServiceImpl();
//		UserHandler userHandler = new UserHandler(userServiceImpl);
		
		return RouterFunctions.route(
				RequestPredicates.GET("/user/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),userHandler::getUserById
				).andRoute(RequestPredicates.GET("/user").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), userHandler::showUsers)
		;
	}
	
	@Bean
	public void createReactorServer() {
		RouterFunction<ServerResponse> function = routerFunction();
		HttpHandler httpHandler = RouterFunctions.toHttpHandler(function);
		ReactorHttpHandlerAdapter reactorHttpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
		
		HttpServer httpServer = HttpServer.create();
		httpServer.handle(reactorHttpHandlerAdapter).bindNow();
	}
	
//	public static void main(String[] args) throws Exception{
//		UserRouter userRouter = new UserRouter();
//		userRouter.createReactorServer();
//		System.out.println("enter to close");
//		System.in.read();
//	}
}
