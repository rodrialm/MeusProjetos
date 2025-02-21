package proativa.projeto.modelo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import proativa.projeto.visao.Aplicacao;

public class ControladorCarregamento {
	
	private Aplicacao aplicacao;
	
    @FXML
    private Button btnVoltar; // Botão para voltar à cena principal

    
    public void setMainApp(Aplicacao mainApp) {
        this.aplicacao = mainApp;
    }
    @FXML
    private void voltarParaMain() throws IOException {
        // Carrega o arquivo FXML da cena principal
        Parent root = FXMLLoader.load(getClass().getResource("/views/main.fxml"));

        // Obtém o Stage atual a partir do botão clicado
        Stage stage = (Stage) btnVoltar.getScene().getWindow();

        // Define a nova cena no Stage
        stage.setScene(new Scene(root));
        stage.setTitle("Cena Principal");
    }
}
