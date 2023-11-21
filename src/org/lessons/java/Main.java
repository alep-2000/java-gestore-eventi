package org.lessons.java;

import java.time.LocalDate;


import org.lessons.java.pojo.Evento;

public class Main {
	public static void main(String[] args) {
		
		try {
			Evento e = new Evento("Festa", LocalDate.parse("2023-11-21"), 50);
			e.addOnePrenotati();
			e.addOnePrenotati();
			e.removeOnePrenotati();
			
		
			
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
	}
}
