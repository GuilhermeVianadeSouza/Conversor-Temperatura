package br.dev.guilhermeViana.temperatura.gui;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.dev.guilhermeViana.temperatura.model.Temperatura;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaConversor {
	//criando os Jlabel,JButton e JtextField
	private String conversorDeTemperatura;
	private JTextField textCelsius;
	private JLabel labelCelsius; 
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	
	//Criacao da tela, moldando seu tamanho e definindo layout, se pode ser alterada seu tamanho.
	public void criarTela(String conversorDeTemperatura) {
		this.conversorDeTemperatura = conversorDeTemperatura;
		JFrame tela = new JFrame();
		tela.setTitle(conversorDeTemperatura);
		tela.setSize(500, 300);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		
		//container para 
		Container container = tela.getContentPane();
		
		//Criacao das fontes. Dando a elas um tamanho, estilo de fonte e método utilizado.
		Font fontePrincipal = new Font("Arial", Font.ITALIC, 28);
		Font fonteResultado = new Font("Arial", Font.ITALIC, 24);
		Font fonteErro = new Font("Arial", Font.ITALIC, 18);
		
		//Jlabel para Celsius. Definindo a font e sua localização.
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius");
		labelCelsius.setFont(fontePrincipal);
		labelCelsius.setBounds(50, 10, 500, 30);
		
		//JTextFiel para escrever os Celsius.
		textCelsius = new JTextField();
		textCelsius.setBounds(80, 50, 300, 35);
		
		//Botao para o calculo do Fahrenheit
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(70, 90, 150, 40);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(230, 90, 150, 40);
		
		labelResultado = new JLabel();
		labelResultado.setText("Resultado");
		labelResultado.setBounds(150, 120, 350, 70);
		labelResultado.setFont(fonteResultado);
		labelResultado.setVisible(false);
		
		labelMensagemErro = new JLabel("Erro. Utilizar apenas números válidos.");
		labelMensagemErro.setForeground(Color.red);
		labelMensagemErro.setBounds(70, 120, 350, 70);
		labelMensagemErro.setFont(fonteErro);
		labelMensagemErro.setVisible(false);
		
		
		container.add(buttonKelvin);
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonFahreinheit);
		container.add(labelResultado);
		container.add(labelMensagemErro);
		
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Deixando a mensagem de erro sem ser visivel
				try {
					labelMensagemErro.setVisible(false);
				
					//Trocando o . por , no label
				String Celsius = textCelsius.getText();
				if (!(Celsius.indexOf(",") == -1)) {
					Celsius = Celsius.replace(",", ".");
				}
				if (!(Celsius.indexOf(" ") == -1)) {
					Celsius = Celsius.replace(" ", "");
				}
				
				//Funcao do botao 
				Temperatura temperatura = new Temperatura();
				temperatura.setCelsius(Double.parseDouble(Celsius));
				temperatura.converterParaKelvin();			
				double Kelvin = temperatura.converterParaKelvin();
				String resultado = Kelvin+" kelvin";
				
				//Deixando visivel o resultado do calculo.
				labelResultado.setVisible(true);
				labelResultado.setText(resultado);
				
} catch (NumberFormatException exception) {
					
					//Esconde o resultado anterior, se tiver algum caracter que nao entre para o calculo do resultado
					labelResultado.setVisible(false);
					//Deixa a mensagem de erro visivel.
					labelMensagemErro.setVisible(true);
					
				}
				
			}
		});
		
		//Realizando os mesmo procedimentos do botao Fahrenheit.
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				labelMensagemErro.setVisible(false);
					
				String Celsius = textCelsius.getText();
				if (!(Celsius.indexOf(",") == -1)) {
					Celsius = Celsius.replace(" ", "");
				}
				Temperatura temperatura = new Temperatura();
				temperatura.setCelsius(Double.parseDouble(Celsius));
				temperatura.converterParaFahrenheit();
				double Fahrenheit = temperatura.converterParaFahrenheit();
				String resultado = Fahrenheit+" fahrenheit";
				
				labelResultado.setVisible(true);
				labelResultado.setText(resultado);
				
	} catch (NumberFormatException excepcion) {
		
		labelResultado.setVisible(false);
		labelMensagemErro.setVisible(true);
	}
				
			}
		});
		//Deixando por fim a tela visivel
		tela.setVisible(true);
	}	
}


