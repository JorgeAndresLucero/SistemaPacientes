package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.sistemapacientes.mundo.Fecha;
import uniandes.cupi2.sistemapacientes.mundo.Paciente;
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
		panelDatosPaciente = new PanelDatosPaciente(this);
		panelDatosMuestra = new PanelDatosMuestra(this);
		panelExtensiones = new PanelExtensiones(this);
		
		add(panelDatosPaciente, BorderLayout.NORTH);
		add(panelDatosMuestra, BorderLayout.CENTER);
		add(panelExtensiones, BorderLayout.SOUTH);
		
		//Crea la clase principal 
		sistemaPacientes = new SistemaPacientes();
	}
	
	
	public void actualizarInfoPaciente(Paciente pPaciente) {
		String nombre = pPaciente.darNombre();
		String apellido = pPaciente.darApellido();
		
		String sexo = "F";
		int isexo = pPaciente.darSexo();
		if(isexo == 2)
			sexo = "M";
	
		String fechaTomaMuestra = pPaciente.darFechaTomaMuestra();
		String dechaN = pPaciente.darFechaNacimiento();
		String imagen = pPaciente.darImagen();
		double volumenMuestra = pPaciente.darVolumenMuestra();
		double volumenEritrocitos = pPaciente.darVolumenEritrocitos();
		int conteoLeucocitos = pPaciente.darConteoLeucocitos();
		int conteoPlaquetas = pPaciente.darConteoPlaquetas();
		boolean enAyunas = pPaciente.darEnAyunas();
		String edad = pPaciente.darEdad();
		
		panelDatosPaciente.actualizarCampos(nombre, apellido, sexo, dechaN,edad, imagen);
		panelDatosMuestra.actualizarCampos(fechaTomaMuestra, enAyunas, volumenMuestra,
										  volumenEritrocitos, conteoLeucocitos,
										  conteoPlaquetas, edad);
		panelDatosMuestra.limpiarCampos();
	}
	
	public void avanzar() {
		Paciente actual = sistemaPacientes.darPacienteSiguiente();
		actualizarInfoPaciente(actual);
	}
	
	public void retroceder() {
		Paciente actual = sistemaPacientes.darPacienteAnterior();
		actualizarInfoPaciente(actual);
	}
	
	public void calcularEdad() {
		String edad = sistemaPacientes.darPacienteActual().darEdad();
		panelDatosPaciente.mostrarEdad(edad);
	}
	
	public void calcularHematocrito() {
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();
		
		if(pVolumenMuestra.trim().equals("") || pVolumenEritrocitos.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.", 
										  "Calcular Hematrocito", JOptionPane.ERROR_MESSAGE);
		} else if(pVolumenMuestra.trim().matches("[0123456789.]*") &&
				  pVolumenEritrocitos.trim().matches("[0123456789.]*")) {
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());
			double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim());
			
			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
			
			double hematocrito = sistemaPacientes.darPacienteActual().calcularHematocrito();
			hematocrito = Math.round(hematocrito * 100.0) / 100.0;
			panelDatosMuestra.mostrarHematocrito(" " + hematocrito);
		} else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.",
										  "Calcular Hematrocrito",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void calcularLeucocito() {
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		String pConteoLeucocitos = panelDatosMuestra.darConteoLeucocitos();
		String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();
		
		
		if(pVolumenMuestra.trim().equals("") || pConteoLeucocitos.trim().equals("") || pVolumenEritrocitos.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.", 
										  "Calcular Leucocito", JOptionPane.ERROR_MESSAGE);
		} else if(pVolumenMuestra.trim().matches("[0123456789.]*") &&
				pConteoLeucocitos.trim().matches("[0123456789.]*") &&
				pVolumenEritrocitos.trim().matches("[0123456789.]*")) {
			
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());
			int conteoLeucocitos = Integer.parseInt(pConteoLeucocitos.trim());
			double volumenEritrocitos =  Double.parseDouble(pVolumenEritrocitos.trim());
			
			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarConteoLeucocitos(conteoLeucocitos);
			sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
			
			double leucocito = sistemaPacientes.darPacienteActual().calcularLeucocitos();
			leucocito = Math.round(leucocito);
			panelDatosMuestra.mostrarLeucocito(" " + leucocito);
		} else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.",
										  "Calcular Leucocito",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cambiarEnAyunas() {
		if(panelDatosMuestra.estaEnAyunas()) {
			JOptionPane.showMessageDialog(this, "En ayunas", "Estado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "No en ayunas", "Estado", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void reqFuncOpcion1() {
		String resultado = sistemaPacientes.metodo1();
		JOptionPane.showMessageDialog(this, resultado,"Respuesta",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void reqFuncOpcion2() {
		String resultado = sistemaPacientes.metodo2();
		JOptionPane.showMessageDialog(this, resultado,"Respuesta",JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		InterfazSistemaPacientes interfaz = new InterfazSistemaPacientes();
		interfaz.setVisible(true);

	}
	
}
