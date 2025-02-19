package proativa.projeto.modelo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controlador {
	
	Arquivo arquivo = new Arquivo();
	@FXML
	private TextArea textArea;

	@FXML
	public void procurarArquivo(ActionEvent event) {

		arquivo.buscarArquivo(event);
		
		System.out.println(arquivo);
	}

	@FXML
	public void lerArquivo() {
		System.out.println("Lendo Arquivo...");
	}
}
