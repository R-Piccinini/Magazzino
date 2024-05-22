package org.generation.italy.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formatter data
		ArrayList<Movimento> elencoMovimenti = new ArrayList<Movimento>(); // dichiarazione arraylist e variabili
		Movimento m;
		Scanner sc = new Scanner(System.in);
		int giacenza = 0;
		String risposta;
		HashMap<Integer, String> fornitori = new HashMap<Integer, String>() { // inizializzazione Hashmaps
			{
				put(01, "Microsoft");
				put(02, "IBM");
				put(03, "Apple");
				put(04, "AMD");
				put(05, "Intel");

			}
		};
		HashMap<Integer, String> clienti = new HashMap<Integer, String>() {
			{
				put(01, "Sigma Spa");
				put(02, "Microtec Srl");
				put(03, "Asem Srl");
				put(04, "Halley Srl");
				put(05, "Gigabyte Spa");

			}
		};
		HashMap<Integer, String> prodotti = new HashMap<Integer, String>() {
			{
				put(01, "Smartphones");
				put(02, "PC");
				put(03, "Processori");
				put(04, "Periferiche");
				put(05, "Monitor");

			}
		};
		HashMap<String, String> tipologieMovimento = new HashMap<String, String>() {
			{
				put("E01", "acquisto da fornitore");
				put("E02", "reso da cliente");
				put("E03", "produzione interna");
				put("E04", "spostamento da altro magazzino");
				put("U01", "vendita a cliente");
				put("U02", "reso a fornitore");
				put("U03", "sostituzione in garanzia");
				put("U04", "spostamento a altro magazzino");
			}
		};
		do { // ciclo selezione programma
			System.out.println(
					"selezione programma:(Aggiunta movimenti(1),Visualizza movimenti(2),Giacienza(3),Esci programma(4))");
			risposta = sc.nextLine();
			while (!(risposta.equals("1") || risposta.equals("2") || risposta.equals("3") || risposta.equals("4"))) {
				System.out.println("(Aggiunta movimenti(1),Visualizza movimenti(2),Giacienza(3),Esci programma(4)");
				risposta = sc.next(); // check risposta per il ciclo
			}

			if (risposta.equals("1")) { // aggiunta movimenti
				System.out.println("Inserisci numero movimenti:");
				int nrMovimenti = sc.nextInt();
				sc.nextLine();

				for (int i = 1; i <= nrMovimenti; i++) {
					m = new Movimento();
					m.codMovimento = i;
					System.out.println("movimento n" + m.codMovimento);
					System.out.println("Inserisci data: ");
					m.data = LocalDate.parse(sc.nextLine(), df);
					sc.nextLine();
					System.out.println("Inserisci cod. prodotto(01-05):");
					m.codProdotto = sc.nextInt();
					sc.nextLine();
					System.out.println("inserisci riferimento (E01-04/U01-04)");
					m.riferimento = sc.nextLine();
					// selezione se entrata o uscita di prodotto
					if (m.riferimento.equals("E01") || m.riferimento.equals("E02") || m.riferimento.equals("E03")
							|| m.riferimento.equals("E04") || m.riferimento.equals("E05")) {
						System.out.println("inserisci cod. fornitore(01-05)");
						m.codFornitore = sc.nextInt();
						System.out.println("Inserisci qnt. prodotto:");
						m.qntProdotto = sc.nextInt();
						sc.nextLine();

					} else {
						System.out.println("inserisci cod. cliente(01-05)");
						m.codCliente = sc.nextInt();
						System.out.println("Inserisci qnt. prodotto:");
						m.qntProdotto = sc.nextInt();
						sc.nextLine();
					}

					elencoMovimenti.add(m);
				}
			} else if (risposta.equals("2")) { // visualizzazione movimenti

				System.out.println("Movimenti in entrata:");
				for (int i = 0; i < elencoMovimenti.size(); i++) { // condizioni movimenti entrata
					if (elencoMovimenti.get(i).riferimento.equals("E01")
							|| elencoMovimenti.get(i).riferimento.equals("E02")
							|| elencoMovimenti.get(i).riferimento.equals("E03")
							|| elencoMovimenti.get(i).riferimento.equals("E04")) {
						System.out.print("Codice Movimento: " + elencoMovimenti.get(i).codMovimento + " "); // nmovimento
						System.out.print(elencoMovimenti.get(i).data + " "); // data
						System.out.print("rif: " + tipologieMovimento.get(elencoMovimenti.get(i).riferimento) + " "); // rif
						System.out.print("prodotto: " + prodotti.get(elencoMovimenti.get(i).codProdotto) + " ");// nomeprod
						System.out.print("fornitore: " + fornitori.get(elencoMovimenti.get(i).codFornitore) + " ");// nomefornitore
						System.out.print("qnt " + elencoMovimenti.get(i).qntProdotto + " "); // qnt
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("Movimenti in uscita:");
				System.out.println();
				for (int i = 0; i < elencoMovimenti.size(); i++) { // condizioni movimenti uscita
					if (elencoMovimenti.get(i).riferimento.equals("U01")
							|| elencoMovimenti.get(i).riferimento.equals("U02")
							|| elencoMovimenti.get(i).riferimento.equals("U03")
							|| elencoMovimenti.get(i).riferimento.equals("U04")) {
						System.out.print("Codice Movimento: " + elencoMovimenti.get(i).codMovimento + " "); // nmovimento
						System.out.print(elencoMovimenti.get(i).data + " "); // data
						System.out.print("rif: " + tipologieMovimento.get(elencoMovimenti.get(i).riferimento) + " "); // rif
						System.out.print("prodotto: " + prodotti.get(elencoMovimenti.get(i).codProdotto) + " "); // nomeprod
						System.out.print("cliente: " + clienti.get(elencoMovimenti.get(i).codCliente) + " "); // nomeclient
						System.out.print("qnt: " + elencoMovimenti.get(i).qntProdotto + " "); // qnt
						System.out.println();
					}

				}
			} else if (risposta.equals("3")) {
				System.out.println("Inserisci codice prodotto:"); // menù giacenza
				int codice = sc.nextInt();
				sc.nextLine();
				for (int i = 0; i < elencoMovimenti.size(); i++) {
					if (elencoMovimenti.get(i).codProdotto == codice) {
						if (elencoMovimenti.get(i).riferimento.startsWith("E")) {// incremento se codici entrata E else
																					// diminuzione
							giacenza = giacenza + elencoMovimenti.get(i).qntProdotto;
							System.out.println("qnt in magazzino:" + giacenza);
						} else {
							giacenza = giacenza - elencoMovimenti.get(i).qntProdotto;
							System.out.println("qnt in magazzino:" + giacenza);
						}
					}
				}

			}
		} while (!(risposta.equals("4")));// se uguale 4 chiudi ciclo

		System.out.println("Arrivederci");
		sc.close();
	}// fine class
}// fine main
