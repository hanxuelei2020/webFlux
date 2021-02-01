package com.example.demo.reactor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestReactor {
	public static void main(String[] args) {
		//just方法直接声明
		Flux.just(1,2,3,4).subscribe(System.out::print);
		Mono.just(1).subscribe(System.out::print);
		
		//其他方法
//		Integer[] array = {1,3,42};
//		Flux.fromArray(array);
//		
//		List<Integer> asList = Arrays.asList(array);
//		Flux.fromIterable(asList);
//		
//		Stream<Integer> stream = asList.stream();
//		Flux.fromStream(stream);
		
		
		
	}
}
