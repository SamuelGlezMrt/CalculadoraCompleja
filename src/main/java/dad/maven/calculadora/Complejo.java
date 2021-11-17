package dad.maven.calculadora;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {

	private DoubleProperty real = new SimpleDoubleProperty();
	private DoubleProperty imaginario = new SimpleDoubleProperty();;

	public String toString() {
		return "(" + getReal() + ", " + getImaginario() + ")";
	}

	public final DoubleProperty realProperty() {
		return this.real;
	}

	public final double getReal() {
		return this.realProperty().get();
	}

	public final void setReal(final double real) {
		this.realProperty().set(real);
	}

	public final DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}

	public final double getImaginario() {
		return this.imaginarioProperty().get();
	}

	public final void setImaginario(final double imaginario) {
		this.imaginarioProperty().set(imaginario);
	}

	public Complejo sumar(Complejo suma) {

		Complejo sum = new Complejo();
		sum.realProperty().bind(realProperty().add(suma.realProperty()));
		sum.imaginarioProperty().bind(imaginarioProperty().add(suma.imaginarioProperty()));

		return sum;

	}

	public Complejo restar(Complejo resta) {

		Complejo res = new Complejo();
		res.realProperty().bind(realProperty().subtract(resta.realProperty()));
		res.imaginarioProperty().bind(imaginarioProperty().subtract(resta.imaginarioProperty()));

		return res;

	}

	public Complejo muliplicacion(Complejo multicar) {

		Complejo multi = new Complejo();
		multi.realProperty().bind(realProperty().multiply(multicar.realProperty())
				.subtract(imaginarioProperty().multiply(multicar.imaginarioProperty())));
		multi.imaginarioProperty().bind(realProperty().multiply(multicar.imaginarioProperty())
				.add(imaginarioProperty().multiply(multicar.realProperty())));
		return multi;

	}

	public Complejo division(Complejo dividir) {
		Complejo div = new Complejo();
		div.realProperty()
				.bind((realProperty().multiply(dividir.realProperty())
						.add(imaginarioProperty().multiply(dividir.imaginarioProperty())))
								.divide(dividir.realProperty().multiply(dividir.realProperty())
										.add(dividir.imaginarioProperty().multiply(dividir.imaginarioProperty()))));

		div.imaginarioProperty()
				.bind((imaginarioProperty().multiply(dividir.realProperty())
						.subtract(realProperty().multiply(dividir.imaginarioProperty())))
								.divide(dividir.realProperty().multiply(dividir.realProperty())
										.add(dividir.imaginarioProperty().multiply(dividir.imaginarioProperty()))));

		return div;
	}

}
