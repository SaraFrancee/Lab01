package it.polito.tdp.Lab01.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	List<String> elencoParole;
		
	public Parole() {
		elencoParole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		for (String parola : elencoParole) {
			if (parola.toLowerCase().equals(p.toLowerCase()))
				return;
		}
		elencoParole.add(p);
	}
	
	public List<String> getElenco() {
		LinkedList<String> copia = new LinkedList<String>(elencoParole);
		Collections.sort(copia);
		return copia;
	}
	
	public void reset() {
		elencoParole.clear();
		return;
	}

}