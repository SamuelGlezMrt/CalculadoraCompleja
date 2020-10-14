package dad.javafx.calculadora.compleja;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CalculadoraCompleja extends Application {

	private ComboBox<String> cbOperadores;
	private TextField tfNumeradorA;
	private TextField tfNumeradorB;
	private TextField tfDenominadorA;
	private TextField tfDenominadorB;
	private TextField tfResA;
	private TextField tfResB;

	private String[] operadores = { "+", "-", "*", "/" };

	private Complejo complejoA;
	private Complejo complejoB;
	private Complejo resultado;

//	private void onCambiarAction(ActionEvent e) {
//		String operacion = cbOperadores.getSelectionModel().getSelectedItem();
//		Complejo aux = new Complejo();
//
//		switch (operacion) {
//		case "+":
//			aux = complejoA.add(complejoB);
//			break;
//		case "-":
//			aux = complejoA.substract(complejoB);
//			break;
//		case "*":
//			aux = complejoA.multiply(complejoB);
//			break;
////		case "/":
////			aux = complejoA.divide(complejoB);
////			break;
//		}
//		resultado.setReal(aux.getReal());
//		resultado.setImaginario(aux.getImaginario());
//	}

	public void start(Stage primaryStage) throws Exception {

		/* Operadores */

		cbOperadores = new ComboBox<String>();
		cbOperadores.getItems().addAll(operadores);
		cbOperadores.getSelectionModel().selectFirst();
		//cbOperadores.setOnAction(e -> onCambiarAction(e));

		VBox vbOperacion = new VBox();
		vbOperacion.getChildren().add(cbOperadores);
		vbOperacion.setAlignment(Pos.CENTER);

		/* 1 numero */
		tfNumeradorA = new TextField("0");
		tfNumeradorA.setPrefColumnCount(4);
		tfNumeradorA.setMaxWidth(100);
		tfNumeradorA.setAlignment(Pos.CENTER);

		tfNumeradorB = new TextField("0");
		tfNumeradorB.setPrefColumnCount(4);
		tfNumeradorB.setMaxWidth(100);
		tfNumeradorB.setAlignment(Pos.CENTER);

		HBox hbNumerador = new HBox();
		hbNumerador.setSpacing(5);
		hbNumerador.getChildren().addAll(tfNumeradorA, new Label("+"), tfNumeradorB, new Label("i"));

		complejoA = new Complejo();

		Bindings.bindBidirectional(tfNumeradorA.textProperty(), complejoA.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfNumeradorB.textProperty(), complejoA.imaginarioProperty(),
				new NumberStringConverter());

		/* 2 numero */

		tfDenominadorA = new TextField("0");
		tfDenominadorA.setPrefColumnCount(4);
		tfDenominadorA.setMaxWidth(100);
		tfDenominadorA.setAlignment(Pos.CENTER);

		tfDenominadorB = new TextField("0");
		tfDenominadorB.setPrefColumnCount(4);
		tfDenominadorB.setMaxWidth(100);
		tfDenominadorB.setAlignment(Pos.CENTER);

		HBox hbDenominador = new HBox();
		hbDenominador.setSpacing(5);
		hbDenominador.getChildren().addAll(tfDenominadorA, new Label("+"), tfDenominadorB, new Label("i"));

		complejoB = new Complejo();

		Bindings.bindBidirectional(tfDenominadorA.textProperty(), complejoB.realProperty(),
				new NumberStringConverter());
		Bindings.bindBidirectional(tfDenominadorB.textProperty(), complejoB.imaginarioProperty(),
				new NumberStringConverter());

		// Resultado

		tfResA = new TextField("0");
		tfResA.setPrefColumnCount(4);
		tfResA.setMaxWidth(100);
		tfResA.setAlignment(Pos.CENTER);
		tfResA.setDisable(true);

		tfResB = new TextField("0");
		tfResB.setPrefColumnCount(4);
		tfResB.setMaxWidth(100);
		tfResB.setAlignment(Pos.CENTER);
		tfResB.setDisable(true);

		resultado = new Complejo();

		Bindings.bindBidirectional(tfResA.textProperty(), resultado.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfResB.textProperty(), resultado.imaginarioProperty(), new NumberStringConverter());

		HBox hbResultado = new HBox();
		hbResultado.setSpacing(5);
		hbResultado.getChildren().addAll(tfResA, new Label("+"), tfResB, new Label("i"));

		VBox vbNumeros = new VBox();
		vbNumeros.setAlignment(Pos.CENTER);
		vbNumeros.getChildren().addAll(hbNumerador, hbDenominador, new Separator(), hbResultado);

		// Elemento Raiz

		HBox root = new HBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(vbOperacion, vbNumeros);

		Scene escena = new Scene(root, 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
