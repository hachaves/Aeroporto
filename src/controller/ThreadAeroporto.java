package controller;

import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {

	// 0 = norte, 1 = sul
	private int pista;
	private Semaphore qtDecolar;
	private int nAviao;

	public ThreadAeroporto(int pista, Semaphore qtDecolar, int nAviao) {
		this.pista = pista;
		this.qtDecolar = qtDecolar;
		this.nAviao = nAviao;
	}

	@Override
	public void run() {
		decolar();
	}

	private void decolar() {
		try {
			qtDecolar.acquire();
			manobrar();
			taxiar();
			decolagem();
			afastamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			qtDecolar.release();
		}
		String nomePista;
		if (pista == 0) {
			nomePista = "norte";
		} else {
			nomePista = "sul";
		}
		System.out.println("Avião " + nAviao + " decolou pela pista " + nomePista);
	}

	private void manobrar() {
		int tpManobra = (int) ((Math.random() * 4001) + 3000);
		try {
			sleep(tpManobra);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void taxiar() {
		int tpTaxiar = (int) ((Math.random() * 5001) + 5000);
		try {
			sleep(tpTaxiar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void decolagem() {
		int tpDecolagem = (int) ((Math.random() * 3001) + 1000);
		try {
			sleep(tpDecolagem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void afastamento() {
		int tpAfastamento = (int) ((Math.random() * 5001) + 3000);
		try {
			sleep(tpAfastamento);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
