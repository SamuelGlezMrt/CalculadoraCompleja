package dad.maven.calculadora;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CalculadoraCompleja extends Application {

	// Combo de los signos
	private ComboBox<String> signosCombo;

	// label
	private Label iLabel;

	// textfiel de los valores
	private TextField numerador1text;
	private TextField num1text;
	private TextField numerador2text;
	private TextField num2text;
	private TextField denominador1text;
	private TextField denominador2text;

	@Override
	public void start(Stage primaryStage) throws Exception {

		signosCombo = new ComboBox<String>();
		signosCombo.getItems().addAll("+" + "-" + "*" + "/");

		iLabel = new Label("i");

		numerador1text = new TextField();
		num1text = new TextField();

		numerador2text = new TextField();
		num2text = new TextField();

		denominador1text = new TextField();
		denominador2text = new TextField();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
