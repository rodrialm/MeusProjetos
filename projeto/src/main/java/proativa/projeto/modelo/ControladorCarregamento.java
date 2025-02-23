package proativa.projeto.modelo;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import proativa.projeto.visao.Aplicacao;

public class ControladorCarregamento {

//	Controlador controladorPrincipal;
	private Aplicacao aplicacao;

	@FXML
	TableView<Pessoa> tabelaPessoas;

	@FXML
	private TableColumn<Pessoa, String> colunaNome;

	@FXML
	private TableColumn<Pessoa, String> colunaEmail;

    private DadosPessoasServicos servicoDeDados = DadosPessoasServicos.getInstance();

	public void setMainApp(Aplicacao mainApp) {
		this.aplicacao = mainApp;

		colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		colunaEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		
//		tabelaPessoas.getColumns().addAll(colunaNome, colunaEmail);
		List<Pessoa> pessoas = servicoDeDados.getPessoas();

		ObservableList<Pessoa> observablePessoas;
		observablePessoas = FXCollections.observableArrayList(pessoas);
		tabelaPessoas.setItems(observablePessoas);
	}

	@FXML
	public void fechar() {
		
		
		System.exit(0);
	}

	@FXML
	private void voltarParaMain() {
		try {
			aplicacao.carregarCenaPrincipal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
