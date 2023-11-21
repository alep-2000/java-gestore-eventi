package org.lessons.java.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi{

	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		setTitolo(titolo);
		this.eventi = new ArrayList<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }
	
	public List<Evento> eventiInData(LocalDate data) {
        List<Evento> eventiInData = new ArrayList<>();

        for (Evento evento : eventi) {
            if (evento.getData().isEqual(data)) {
                eventiInData.add(evento);
            }
        }

        return eventiInData;
    }
	
	public int quantitaEvento() {
		return eventi.size(); 
	}
	
	public void pulisciEvento(){
		getEventi().clear();
	}
	
	public String ProgrammaOrdinatoPerData() {
        Collections.sort(eventi, Comparator.comparing(Evento::getData));
        
        StringBuilder result = new StringBuilder("Titolo del programma: " + titolo + "\n");

        for (Evento evento : eventi) {
            result.append(evento).append("\n");
        }

        return result.toString();
    }
	
	@Override
	public String toString() {
		return "Titolo: " + getTitolo()+ "\n"
				+ "Lista eventi: " + getEventi();
		
	}
}
