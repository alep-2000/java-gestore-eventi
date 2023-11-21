package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.lessons.java.pojo.Evento;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try {
			
			System.out.print("Vuoi inserire un nuovo evento (si-no)");
			String nuovoEvento = in.nextLine();
			
			System.out.print("Inserisci il nome dell'evento: ");
			String nomeEvento = in.nextLine();
			
			System.out.print("Inserisci la data dell'evento (formato dd-MM-yyyy): ");
			String dataEvento = in.nextLine();
			LocalDate dateEvent = LocalDate.parse(dataEvento, 			DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			
			System.out.print("Inserisci il numero di posti totali: ");
			String postiTotali = in.nextLine();
			int intpTotali = Integer.valueOf(postiTotali);
			
			if(nuovoEvento.equals("no")) {
				System.out.println("Programma terminato");
			}
			
			
			
			Evento e = new Evento(nomeEvento, dateEvent, intpTotali);
            
            System.out.print("Vuoi effettuare nuove prenotazioni (si-no)");
			String nuovoEvento2 = in.nextLine();
			
			if(nuovoEvento2.equalsIgnoreCase("si")) {
				System.out.print("Quante prenotazioni vuoi effettuare: ");
				String nPrenotazioni = in.nextLine();
				int intnPrenotazioni = Integer.valueOf(nPrenotazioni);			
				
				for (int i = 0; i < intnPrenotazioni; i++) {
					try {
						e.addOnePrenotati(); 
						System.out.println(e);
					} catch (IllegalArgumentException e1) {
						System.err.println("Errore nella prenotazione: " + e1.getMessage());
						break;
					}
			}
				
			 System.out.print("Quanti posti vuoi disdire: ");
			 String postiDisdetti = in.nextLine();
			 int intnDisdette = Integer.valueOf(postiDisdetti);	
		
			 for (int i = 0; i < intnDisdette; i++) {
					try {
						e.removeOnePrenotati();; 
						System.out.println(e);
					} catch (IllegalArgumentException e1) {
						System.err.println("Errore nella prenotazione: " + e1.getMessage());
						break;
					}
			 }
			 
			}
			
			in.close();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
	
	}
}

