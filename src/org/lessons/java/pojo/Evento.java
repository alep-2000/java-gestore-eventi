package org.lessons.java.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	private String titolo;
	protected LocalDate data;
	private int nPostiTotali;
	private int nPrenotati;
	
	public Evento(String titolo, LocalDate data, int nPostiTotali){
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
	
	public void addOnePrenotati() {
		
		if (this.data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La data dell'evento è già passata.");
		}
		
		if ( nPostiTotali == nPrenotati) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili.");
        }
		
		setnPrenotati(getnPrenotati() + 1);
	}
	
	public void removeOnePrenotati() {
		if (this.data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La data dell'evento è già passata.");
		}
		
		if ( nPrenotati == 0) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili.");
        }
		
		setnPrenotati(getnPrenotati() - 1);
	}
	
	private String dataFormattataTitolo() {
        String dataFormattata = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return dataFormattata + " - " + getTitolo();
    
	}
	
	private int postiDisponibili() {
		int postiDisponibili = getnPostiTotali() - getnPrenotati();
		return postiDisponibili;
	}

	@Override
	public String toString() {
		
		return "Data + Titolo: " + dataFormattataTitolo() + "\n"
				+ "Numero Posti Totali: " + getnPostiTotali() + "\n"
				+ "Numero Posti Prenotati: " + getnPrenotati() + "\n"
				+ "Posti disponibili: " + postiDisponibili() + "\n"
				+ "------------------------------------------------------------" + "\n";
	}
}
