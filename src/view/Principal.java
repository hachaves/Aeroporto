package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Principal {

	public static void main(String[] args) {
		int permit = 2;
		Semaphore qtDecolar = new Semaphore(permit);
		
		for(int i = 1; i<=12; i++) {
			int pista =(int) (Math.round(Math.random()));
			Thread aeroporto = new ThreadAeroporto(pista, qtDecolar, i);
			aeroporto.start();
		}
	}

}
