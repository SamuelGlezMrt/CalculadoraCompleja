package dad.javafx.calculadora.compleja;

import java.awt.event.ActionEvent;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

	public void start(Stage primaryStage) throws Exception {

		/* Operadores */
		cbOperadores = new ComboBox<String>();
		cbOperadores.getItems().addAll(operadores);
		cbOperadores.getSelectionModel().selectFirst();

		VBox vbOperaciones = new VBox();
		vbOperaciones.getChildren().add(cbOperadores);
		vbOperaciones.setAlignment(Pos.CENTER);

		/* 1 numero */
		tfNumeradorA = new TextField("0");
		tfNumeradorA.setPrefColumnCount(4);
		tfNumeradorA.setMaxWidth(100);
		tfNumeradorA.setAlignment(Pos.CENTER);

		tfNumeradorB = new TextField("0");
		tfNumeradorB.setPrefColumnCount(4);
		tfNumeradorB.setMaxWidth(100);
		tfNumeradorB.setAlignment(Pos.CENTER);

		HBox hbNumeradores = new HBox();
		hbNumeradores.setSpacing(5);
		hbNumeradores.getChildren().addAll(tfNumeradorA, new Label("+"), tfNumeradorB, new Label("i"));

		/* Bindings para el primer numero */

		complejoA = new Complejo();

		Bindings.bindBidirectional(tfNumeradorA.textProperty(), complejoA.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfNumeradorB.textProperty(), complejoA.imaginarioProperty(),
				new NumberStringConverter());

		/* 2 numero */
		tfNumeradorA = new TextField("0");
		tfNumeradorA.setPrefColumnCount(4);
		tfNumeradorA.setMaxWidth(100);
		tfNumeradorA.setAlignment(Pos.CENTER);

		tfNumeradorB = new TextField("0");
		tfNumeradorB.setPrefColumnCount(4);
		tfNumeradorB.setMaxWidth(100);
		tfNumeradorB.setAlignment(Pos.CENTER);

		HBox hbDenominador = new HBox();
		hbDenominador.setSpacing(5);
		hbDenominador.getChildren().addAll(tfDenominadorA, new Label("+"), tfDenominadorB, new Label("i"));

		/* Bindings para el segundo numero */
		complejoB = new Complejo();

		Bindings.bindBidirectional(tfDenominadorA.textProperty(), complejoB.realProperty(),
				new NumberStringConverter());
		Bindings.bindBidirectional(tfDenominadorB.textProperty(), complejoB.imaginarioProperty(),
				new NumberStringConverter());

		/* Resultado */

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

		/* Bindings para el resultado */
		resultado = new Complejo();

		Bindings.bindBidirectional(tfResA.textProperty(), resultado.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfResB.textProperty(), resultado.imaginarioProperty(), new NumberStringConverter());

		HBox hbResultado = new HBox();
		hbResultado.setSpacing(5);
		hbResultado.getChildren().addAll(tfResA, new Label("+"), tfResB, new Label("i"));

		VBox vbNumeros = new VBox();
		vbNumeros.setAlignment(Pos.CENTER);
		vbNumeros.getChildren().addAll(hbNumeradores, hbDenominador, new Separator(), hbResultado);

		// Elemento Raiz

		HBox hbPrincipal = new HBox();
		hbPrincipal.setSpacing(5);
		hbPrincipal.setAlignment(Pos.CENTER);
		;
		hbPrincipal.getChildren().addAll(vbOperaciones, vbNumeros);

		Scene escena = new Scene(hbPrincipal, 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
