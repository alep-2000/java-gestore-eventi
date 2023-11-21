package org.lessons.java;

import java.time.LocalDate;

import org.lessons.java.pojo.Evento;
import org.lessons.java.pojo.ProgrammEventi;

public class Main2 {
	public static void main(String[] args) {
		ProgrammEventi pE = new ProgrammEventi("Ciao");
		
		Evento ev1 = null;
		try {
			ev1 = new Evento("evento", LocalDate.parse("2050-12-18"),100);
		}catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		Evento ev2 = null;
		try {
			ev2 = new Evento("evento", LocalDate.parse("2023-12-14"),100);
		}catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		Evento ev3 = null;
		try {
			ev3 = new Evento("evento", LocalDate.parse("2023-12-18"),100);
		}catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		pE.aggiungiEvento(ev1);
		pE.aggiungiEvento(ev2);
		pE.aggiungiEvento(ev3);
//		pE.pulisciEvento();
//		System.out.println(pE.eventiInData(LocalDate.parse("2023-12-18")));
		System.out.println("Numero di eventi presenti: " + pE.quantitaEvento());
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(pE.ProgrammaOrdinatoPerData());
		
		
	}
}
