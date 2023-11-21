package org.lessons.java.pojo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{

	private LocalTime ora;
	private BigDecimal prezzo;
	
	public Concerto(String titolo, LocalDate data, int nPostiTotali, LocalTime orario, BigDecimal prezzo) {
		super(titolo, data, nPostiTotali);
		setOra(orario);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
		
		
	}
	
	public String getOraFormattata() {
        LocalDateTime oraEvento = LocalDateTime.of(getData(), LocalTime.NOON);
        return oraEvento.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
	
   private String getPrezzoFormattato() {
        DecimalFormat df = new DecimalFormat("##,##€");
        
        if (prezzo.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Il prezzo non può essere negativo.");
        }
        return df.format(prezzo);
    }
	
	@Override
	public String toString() {
		return "Data + Ora + Titolo + Prezzo: " + getOraFormattata() + " - " + getTitolo() + " - " + 		getPrezzoFormattato();
	}
}
