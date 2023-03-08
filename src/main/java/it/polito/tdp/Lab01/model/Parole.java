package it.polito.tdp.Lab01.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	List<String> elencoParole;
		
	public Parole() {
		elencoParole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		for (String parola : elencoParole) {
			if (parola.toLowerCase().equals(p.toLowerCase()))
				return;
		}
		elencoParole.add(p);
	}
	
	public List<String> getElenco() {
		ArrayList<String> copia = new ArrayList<String>(elencoParole);
		Collections.sort(copia);
		return copia;
	}
	
	public void reset() {
		elencoParole.clear();
		return;
	}
	
	public void cancel(String s) {
		if (elencoParole.contains(s))
			elencoParole.remove(s);
		return;
	}

}