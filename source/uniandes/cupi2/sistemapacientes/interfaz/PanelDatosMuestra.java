package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelDatosMuestra extends JPanel implements ActionListener{
	
	private InterfazSistemaPacientes principal;
	
	private final static String AYUNAS = "En ayunas";
	private final static String CALCULAR_HEMATROCITO = "CALCULAR HEMATROCITO";
	private final static String CALCULAR_LEUCOCITOS = "CALCULAR LEUCOCITOS";
	
	private JButton butHematocrito;
	private JButton butLeucocitos;
	private JCheckBox cbAyunas;
	
	public PanelDatosMuestra(InterfazSistemaPacientes v) {
		principal = v;
		
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Información muestra");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		butHematocrito = new JButton();
		butHematocrito.setText("Calcular Hematocrito");
		butHematocrito.setActionCommand(CALCULAR_HEMATROCITO);
		butHematocrito.addActionListener(this);
		
		butLeucocitos = new JButton();
		butLeucocitos.setText("Calcular leucocitos");
		butLeucocitos.setActionCommand(CALCULAR_LEUCOCITOS);
		butLeucocitos.addActionListener(this);
		
		cbAyunas = new JCheckBox("Ayunas");
		cbAyunas.setActionCommand(AYUNAS);
		cbAyunas.addActionListener(this);
	}
	
	public String darVolumenMuestra() {
		String rta = txtVoluMenMuestra.getText();
		return rta;
	}
	
	public String darVolumenEritrocitos() {
		String rta = txtVoluEritrocitos.getText();
		return rta;
	}
	
	public String darConteoLeucocitos() {
		String rta = txtConteoLeucocitos.getText();
		return rta;
	}
	
	public String darConteoPlaquetas() {
		String rta = txtConteoPlaquetas.getText();
		return rta;
	}
	
	public boolean estaEnAyunas() {
		return cbAyunas.isSelected();
	}
	
	public void mostrarHematocrito(String pHematrocrito) {
		txtHematrocrito.setText(pHematrocrito + "");
	}
	
	public void mostrarLeucocito(String pLeucocito) {
		txtLeucocitos.setText(pLeucocito + "");
	}
	
	public void mostrarAyunas(boolean pEnAyunas) {
		cbAyunas.setSelected(pEnAyunas);
	}
	
	public void limpiarCampos() {
		txtHematocrito.setText("");
		txtLeucocitos.setText("");
	}
	
	public void actualizarCampos(String pFechaMuestra, boolean pEnAyunas,
								 double pVolumenMuestra, double pVolumenEritrocitos,
								 int pConteoLeucocitos, int pConteoPlaquetas) {
		txtFTomaMuestra.setText(pFechaMuestra);
		txtVolumenMuestra.setText(pVolumenMuestra + "");
		txtVolumenEritrocitos.setText(pVolumenEritrocitos + "");
		txtConteoLeucitos.setText(pConteoLeucocitos + "");
		txtConteoPlaquetas.setText(pConteoPlaquetas + "");
		cbAyunas.setSelected(pEnAyunas);
	}
	
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(CALCULAR_HEMATROCITO)) {
			principal.calcularHematocrito();
		}
		else if(comando.equals(CALCULAR_LEUCOCITOS)) {
			principal.calcularLeucocito();
		}
		else if(comando.equals(AYUNAS)) {
			principal.cambiarEnAyunas();
		}
	}
}
