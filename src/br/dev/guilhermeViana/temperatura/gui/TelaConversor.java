package br.dev.guilhermeViana.temperatura.gui;
import br.dev.guilhermeViana.temperatura.model.Temperatura;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.dev.guilhermeViana.temperatura.model.Temperatura;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaConversor {
	
	private String conversorDeTemperatura;
	private JTextField textCelsius;
	private JLabel labelCelsius; 
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	
	public void criarTela(String conversorDeTemperatura) {
		this.conversorDeTemperatura = conversorDeTemperatura;
		JFrame tela = new JFrame();
		tela.setTitle(conversorDeTemperatura);
		tela.setSize(500, 650);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		
		Container container = tela.getContentPane();
		
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius");
		labelCelsius.setBounds(150, 10, 500, 30);
		
		textCelsius = new JTextField();
		textCelsius.setBounds(10, 50, 250, 35);
		
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(10, 90, 110, 40);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(140, 90, 110, 40);
		
		labelResultado = new JLabel();
		labelResultado.setText("Resultado");
		labelResultado.setBounds(140, 200, 90, 50);
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setText("Erro. Utilizar apenas números válidos.");
		labelMensagemErro.setForeground(Color.red);
		labelMensagemErro.setBounds(200, 150, 200, 70);
		
		
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
				String Celsius = textCelsius.getText();
				
				
				
				double celsiusDouble = Double.parseDouble(Celsius);
				
				Temperatura temperatura = new Temperatura();
				temperatura.setCelsius(celsiusDouble);
				temperatura.getCelsius();
				
				
				
				
				
			}
		});
		
		tela.setVisible(true);
	}	
}


