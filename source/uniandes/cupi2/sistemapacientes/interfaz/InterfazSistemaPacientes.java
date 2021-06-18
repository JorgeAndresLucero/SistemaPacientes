package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import uniandes.cupi2.sistemapacientes.mundo.SistemaPacientes;

public class InterfazSistemaPacientes extends JFrame{
	private SistemaPacientes sistemaPacientes;
	
	InterfazSistemaPacientes(){
		setTitle("Sistema de Pacientes");
		setSize(400,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		//Crea la clase principal 
		sistemaPacientes = new SistemaPacientes();
	}

	public static void main(String[] args) {
		InterfazSistemaPacientes interfaz = new InterfazSistemaPacientes();
		interfaz.setVisible(true);

	}

}
