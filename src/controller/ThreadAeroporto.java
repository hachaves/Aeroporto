package controller;

import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {

	private Semaphore limite;
	private int nAviao;
	private String direcao;

	public ThreadAeroporto(int nAviao, Semaphore limite, String direcao) {
		this.nAviao = nAviao;
		this.direcao = direcao;
		this.limite = limite;
	}

	@Override
	public void run() {
		procedimentoDecolagem();
	}

	private void procedimentoDecolagem() {
		try {
			limite.acquire();
			manobra();
			taxiar();
			decolar();
			afastamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			limite.release();
		}
	}

	private void afastamento() {
		// 1s = 1000ms
		int s = (int) ((Math.random() * 5001) + 3000);
		// dorme 3 a 8 segundos
		try {
			sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O avião " + nAviao + " se afastou após " + (s / 1000) + " segundos");
	}

	private void decolar() {
		// 1s = 1000ms
		int s = (int) ((Math.random() * 3001) + 1000);
		// dorme 1 a 4 segundos
		try {
			sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O avião " + nAviao + " decolou após " + (s / 1000) + " segundos sentido " + direcao);
	}

	private void taxiar() {
		// 1s = 1000ms
		int s = (int) ((Math.random() * 5001) + 5000);
		// dorme 5 a 10 segundos
		try {
			sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O avião " + nAviao + " taxiou " + (s / 1000) + " segundos");
	}

	private void manobra() {
		// 1s = 1000ms
		int s = (int) ((Math.random() * 4001) + 3000);
		// dorme 3 a 7 segundos
		try {
			sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O avião " + nAviao + " manobrou após " + (s / 1000) + " segundos");
	}

}