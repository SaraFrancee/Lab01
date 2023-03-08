package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnCancel;
    
    @FXML
    private Button btnReset;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtPrestazioni;
    
    

    @FXML
    void doInsert(ActionEvent event) {
    	String parolaInserita = txtParola.getText();
    	txtParola.setText("");
    	String fineOutput = "";
    	String output = "";
    	if (elenco.getElenco().size()==0) {
    		elenco = new Parole();
    		btnReset.setDisable(false);
    		btnCancel.setDisable(false);
    	}
    	if (parolaInserita.length()>0) {
    		elenco.addParola(parolaInserita.toLowerCase());
    	}
    	else
    		fineOutput = fineOutput + "Ultima parola inserita non valida";
    	for (String p : elenco.getElenco())
    		output = output + p + "\n";
    	output = output + "\n" + fineOutput;
    	txtResult.setText(output);
    	String tempo = "" + System.nanoTime() + " ns";
    	txtPrestazioni.setText(tempo);
    	return;
    }

    @FXML
    void doReset(ActionEvent event) {
    	btnReset.setDisable(true);
    	btnCancel.setDisable(true);
        elenco.reset();
        txtResult.setText("");
        String tempo = "" + System.nanoTime() + " ns";
    	txtPrestazioni.setText(tempo);
    	return;
    }

    @FXML
    void doCancel(ActionEvent event) {
    	String parolaDaCanc = txtParola.getText();
    	txtParola.setText("");
    	String fineOutput = "";
    	String output = "";
    	if (parolaDaCanc.length()>0) {
    		elenco.cancel(parolaDaCanc.toLowerCase());
    	}
    	else
    		fineOutput = "Parola da cancellare non valida";
    	for (String p : elenco.getElenco())
    		output = output + p + "\n";
    	output = output + "\n" +  fineOutput;
    	txtResult.setText(output);
    	String tempo = "" + System.nanoTime() + " ns";
    	txtPrestazioni.setText(tempo);
    	return;
    }
    
    @FXML
    void initialize() {
    	assert txtPrestazioni != null : "fx:id=\"txtPrestazioni\" was not injected: check your FXML file 'Scene.fxml'.";
    	assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }

}
