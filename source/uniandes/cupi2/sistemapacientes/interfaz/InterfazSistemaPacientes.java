package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import uniandes.cupi2.sistemapacientes.mundo.SistemaPacientes;

public class InterfazSistemaPacientes extends JFrame{
	private SistemaPacientes sistemaPacientes;
	private PanelDatosPaciente panelDatosPaciente;
	private PanelDatosMuestra panelDatosMuestra;
	private PanelExtensiones panelExtensiones;
	
	InterfazSistemaPacientes(){
		setTitle("Sistema de Pacientes");
		setSize(700,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panelDatosPaciente = new PanelDatosPaciente();
		panelDatosMuestra = new PanelDatosMuestra();
		panelExtensiones = new PanelExtensiones();
		
		add(panelDatosPaciente, BorderLayout.NORTH);
		add(panelDatosMuestra, BorderLayout.CENTER);
		add(panelExtensiones, BorderLayout.SOUTH);
		
		//Crea la clase principal 
		sistemaPacientes = new SistemaPacientes();
	}

	public static void main(String[] args) {
		InterfazSistemaPacientes interfaz = new InterfazSistemaPacientes();
		interfaz.setVisible(true);

	}

}
