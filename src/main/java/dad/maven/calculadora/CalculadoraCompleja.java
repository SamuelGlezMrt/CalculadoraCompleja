package dad.maven.calculadora;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CalculadoraCompleja extends Application {

	// Combo de los signos
	private ComboBox<String> signosCombo;

	// textfiel de los valores
	private TextField numerador1text;
	private TextField num1text;
	private TextField numerador2text;
	private TextField num2text;
	private TextField denominador1text;
	private TextField denominador2text;
	private Separator linea;

	Complejo complejo1 = new Complejo();
	Complejo complejo2 = new Complejo();
	Complejo complejoResul = new Complejo();

	@Override
	public void start(Stage primaryStage) throws Exception {

		linea = new Separator();

		signosCombo = new ComboBox<String>();
		signosCombo.getItems().addAll("+", "-", "*", "/");
		signosCombo.getSelectionModel().select(0);

		numerador1text = new TextField();
		numerador1text.setPromptText("0");
		numerador1text.setAlignment(Pos.CENTER);
		numerador1text.setPrefWidth(60);

		num1text = new TextField();
		num1text.setPromptText("0");
		num1text.setAlignment(Pos.CENTER);
		num1text.setPrefWidth(60);

		numerador2text = new TextField();
		numerador2text.setPromptText("0");
		numerador2text.setAlignment(Pos.CENTER);
		numerador2text.setPrefWidth(60);

		num2text = new TextField();
		num2text.setPromptText("0");
		num2text.setAlignment(Pos.CENTER);
		num2text.setPrefWidth(60);

		denominador1text = new TextField();
		denominador1text.setPromptText("0");
		denominador1text.disabledProperty();
		denominador1text.setAlignment(Pos.CENTER);
		denominador1text.setPrefWidth(60);
		denominador1text.setDisable(true);

		denominador2text = new TextField();
		denominador2text.setPromptText("0");
		denominador2text.disabledProperty();
		denominador2text.setAlignment(Pos.CENTER);
		denominador2text.setPrefWidth(60);
		denominador2text.setDisable(true);

		VBox comboBox = new VBox();
		comboBox.setSpacing(5);
		comboBox.setAlignment(Pos.CENTER);
		comboBox.getChildren().addAll(signosCombo);

		HBox numerador1Box = new HBox();
		numerador1Box.setSpacing(5);
		numerador1Box.setAlignment(Pos.CENTER);
		numerador1Box.getChildren().addAll(numerador1text, new Label("+"), numerador2text, new Label("i"));

		HBox numerador2Box = new HBox();
		numerador2Box.setSpacing(5);
		numerador2Box.setAlignment(Pos.CENTER);
		numerador2Box.getChildren().addAll(num1text, new Label("+"), num2text, new Label("i"));

		HBox denominadorBox = new HBox();
		denominadorBox.setSpacing(5);
		denominadorBox.setAlignment(Pos.CENTER);
		denominadorBox.getChildren().addAll(denominador1text, new Label("+"), denominador2text, new Label("i"));

		VBox valoresBox = new VBox();
		valoresBox.setSpacing(5);
		valoresBox.setAlignment(Pos.CENTER);
		valoresBox.getChildren().addAll(numerador1Box, numerador2Box, linea, denominadorBox);

		HBox root = new HBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(comboBox, valoresBox);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.setScene(scene);
		primaryStage.show();

		// bindings
		Bindings.bindBidirectional(numerador1text.textProperty(), complejo1.realProperty(),
				new NumberStringConverter());
		Bindings.bindBidirectional(numerador2text.textProperty(), complejo1.imaginarioProperty(),
				new NumberStringConverter());

		Bindings.bindBidirectional(num1text.textProperty(), complejo2.realProperty(),
				new NumberStringConverter());
		Bindings.bindBidirectional(num2text.textProperty(), complejo2.imaginarioProperty(),
				new NumberStringConverter());

		signosCombo.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> {
			if (signosCombo.getSelectionModel().getSelectedItem().equals("+")) {
				complejoResul = complejo1.sumar(complejo2);
				denominador1text.textProperty().bind(complejoResul.realProperty().asString("%.2f"));
				denominador2text.textProperty().bind(complejoResul.imaginarioProperty().asString("%.2f"));
			}
			if (signosCombo.getSelectionModel().getSelectedItem().equals("-")) {
				complejoResul = complejo1.restar(complejo2);
				denominador1text.textProperty().bind(complejoResul.realProperty().asString("%.2f"));
				denominador2text.textProperty().bind(complejoResul.imaginarioProperty().asString("%.2f"));
			}
			if (signosCombo.getSelectionModel().getSelectedItem().equals("*")) {
				complejoResul = complejo1.muliplicacion(complejo2);
				denominador1text.textProperty().bind(complejoResul.realProperty().asString("%.2f"));
				denominador2text.textProperty().bind(complejoResul.imaginarioProperty().asString("%.2f"));
			}
			if (signosCombo.getSelectionModel().getSelectedItem().equals("/")) {
				complejoResul = complejo1.division(complejo2);
				denominador1text.textProperty().bind(complejoResul.realProperty().asString("%.2f"));
				denominador2text.textProperty().bind(complejoResul.imaginarioProperty().asString("%.2f"));
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}
