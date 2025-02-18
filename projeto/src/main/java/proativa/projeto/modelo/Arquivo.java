package proativa.projeto.modelo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;

public class Arquivo {
	
	@FXML DatePicker date;
	public Arquivo() {
		
	}
	
	@FXML FileChooser arquivo;
	public void buscarArquivo() {
		HSSFWorkbook arquivoEscolhido = new HSSFWorkbook();
	}
}
