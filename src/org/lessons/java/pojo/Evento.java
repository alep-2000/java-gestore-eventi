package org.lessons.java.pojo;

import java.time.LocalDate;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int nPostiTotali;
	private int nPrenotati;
	
	public Evento(String titolo, LocalDate data, int nPostiTotali, int nPrenotati){
			setTitolo(titolo);
			setData(data);
			setnPostiTotali(nPostiTotali);
			setnPrenotati(0);
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
		
		 
        if (this.data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento è già passata.");
        }
	}

	public int getnPostiTotali() {
		return nPostiTotali;
	}

	private void setnPostiTotali(int nPostiTotali) {
		
        if (nPostiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        
		this.nPostiTotali = nPostiTotali;
	}

	public int getnPrenotati() {
		return nPrenotati;
	}

	private void setnPrenotati(int nPrenotati) {
		this.nPrenotati = nPrenotati;
	}

	@Override
	public String toString() {
		
		return "Titolo: " + getTitolo() + "\n"
				+ "Data: " + getData()	+ "\n"
				+ "Numero Posti Totali: " + getnPostiTotali() + "\n"
				+ "Numero Posti Prenotati: " + getnPrenotati();
	}
}
