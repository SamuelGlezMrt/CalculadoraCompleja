package dad.javafx.calculadora.compleja;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {

	private DoubleProperty real = new SimpleDoubleProperty(0);
	private DoubleProperty imaginario = new SimpleDoubleProperty(0);

	public Complejo() {
	}

	public Complejo(double real, double imaginario) {
		super();
		setReal(real);
		setImaginario(imaginario);
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

	@Override
	public String toString() {
		return getReal() + "+" + getImaginario() + "i";
	}

	public Complejo add(Complejo c) {
		Complejo r = new Complejo();
		r.realProperty().bind(real.add(c.realProperty()));
		r.imaginarioProperty().bind(imaginario.add(c.imaginarioProperty()));
		return r;
	}

	public Complejo substract(Complejo s) {
		Complejo r = new Complejo();
		r.realProperty().bind(real.subtract(s.realProperty()));
		r.imaginarioProperty().bind(imaginario.subtract(s.imaginarioProperty()));
		return r;
	}

	public Complejo multiply(Complejo m) {

		Complejo r = new Complejo();
		DoubleProperty realA = realProperty();
		DoubleProperty realB = m.realProperty();
		DoubleProperty imaginarioA = imaginarioProperty();
		DoubleProperty imaginarioB = m.imaginarioProperty();

		r.realProperty().bind(realA.multiply(realB).subtract(imaginarioA.multiply(imaginarioB)));
		r.imaginarioProperty().bind(realA.multiply(imaginarioB).add(imaginarioA.multiply(realB)));
		return r;

	}

	public static void main(String[] args) {
		Complejo a = new Complejo(1, 2);
		Complejo b = new Complejo(3, 4);
		Complejo c = a.add(b);
		Complejo s = a.substract(b);
		Complejo m = a.multiply(b);

		// System.out.println(c);
		// a.setReal(10);
		System.out.println(c);
		// System.out.println();
		System.out.println(s);
		// System.out.println();
		System.out.println(m);
	}

}