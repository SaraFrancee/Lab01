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
    private Button btnReset;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;

    @FXML
    void doInsert(ActionEvent event) {
    	String parolaInserita = txtParola.getText();
    	txtParola.setText("");
    	String fineOutput = "";
    	String output = "";
    	if (elenco.getElenco().size()==0) {
    		elenco = new Parole();
    		btnReset.setDisable(false);
    	}
    	if (parolaInserita.length()>0) {
    		elenco.addParola(parolaInserita.toLowerCase());
    	}
    	else
    		fineOutput = fineOutput + "Ultima parola inserita non valida";
    	for (String p : elenco.getElenco())
    		output = output + p + "\n";
    	output = output + fineOutput;
    	txtResult.setText(output);
    }

    @FXML
    void doReset(ActionEvent event) {
    	btnReset.setDisable(true);
        elenco.reset();
        txtResult.setText("");
    }

    @FXML
    void initialize() {
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }

}
