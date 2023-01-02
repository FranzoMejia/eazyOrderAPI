package com.omejia.springsecuritybasic;

public class PingPong extends Thread {
	private String word; // Lo que va a escribir.
	private int delay; // Tiempo entre escrituras

	public PingPong(String queDecir, int cadaCuantosMs) {
		word = queDecir;
		delay = cadaCuantosMs;
	};

	public void run() {
		while (!Thread.interrupted()) {
			System.out.println("Ejecuto");
		}
		;
		System.out.println("Termino");
		return;
	}
}