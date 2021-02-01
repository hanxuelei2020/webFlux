package com.example.demo.reactor;

import java.util.Observable;

public class Reactor8 extends Observable{
	
	public static void main(String[] args) {
		Reactor8 reactor8 = new Reactor8();
		reactor8.addObserver((o,arg)->{
			System.out.println("开始接受消息");
		});
		
		reactor8.addObserver((o,arg)->{
			System.out.println("开始接受消息2...");
		});
		
		reactor8.setChanged();
		reactor8.notifyObservers();
	}

}
