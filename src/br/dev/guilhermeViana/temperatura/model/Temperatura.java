package br.dev.guilhermeViana.temperatura.model;

public class Temperatura {
	// criação da classe temperatura. Criação do argumento double celsius.
	private double celsius;

	// get do celsius na qual retornará o celsius
	public double getCelsius() {
		return celsius;
	}

	// setcelsius na qual deve deve r
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}

	public double converterParaFahrenheit() {
		double Fahrenheit = celsius * 1.8 + 32;
		return Fahrenheit;
	}

	public double converterParaKelvin() {
		double Kelvin = celsius + 273.15;
		return Kelvin;
	}

	public void teste() {
		System.out.println("Fahrenheit: " + converterParaFahrenheit());
	}

}
