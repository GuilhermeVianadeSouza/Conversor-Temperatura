package br.dev.guilhermeViana.temperatura.model;

public class Temperatura {
	// criação da classe temperatura. Criação do argumento double celsius.
	private double celsius;

	// get do celsius na qual retornará o celsius
	public double getCelsius() {
		return celsius;
	}

	// setcelsius na qual deve enviar um double celsius para outra funcao.
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}

	//conta para conversao de temperatura para Fahrenheit
	public double converterParaFahrenheit() {
		double Fahrenheit = celsius * 1.8 + 32;
		return Fahrenheit;
	}

	//Conta para conversao de temperatura para Kelvin
	public double converterParaKelvin() {
		double Kelvin = celsius + 273.15;
		return Kelvin;
	}
}
