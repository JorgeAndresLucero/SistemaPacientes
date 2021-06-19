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
	private JTextField txtFTomaMuestra;
	private JTextField txtVoluMenMuestra;
	private JTextField txtVolumenEritrocitos;	
	private JTextField txtConteoLeucocitos;
	private JTextField txtConteoPlaquetas;
	private JTextField txtHematocrito;
	private JTextField txtLeucocitos;
	private JTextField txtVolumenMuestra;
	private JLabel labVacio;
	private JLabel labFTomaMuestra;
	private JLabel labVolumenMuestra;
	private JLabel labVolumenEritrocitos;
	private JLabel labConteoLeucocitos;
	private JLabel labConteoPlaquetas;
	
	public PanelDatosMuestra(InterfazSistemaPacientes v) {
		principal = v;
		
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Información muestra");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		JPanel panelMuestra;
		
		panelMuestra = new JPanel();
		add(panelMuestra);
		
		// etiquetas
		labFTomaMuestra = new JLabel("Fecha Toma Muestra: ");
		labVolumenMuestra = new JLabel("Volumen Muestra: ");
		labVolumenEritrocitos = new JLabel("Volumen Eritrocitos: ");
		labConteoLeucocitos = new JLabel("Conteo Leucocitos: ");
		labConteoPlaquetas = new JLabel("Conteo Plaquetas: ");
		labVacio = new JLabel("");
		
		txtFTomaMuestra= new JTextField(15);
		txtFTomaMuestra.setEditable(false);
		txtFTomaMuestra.setForeground(Color.blue);
		
		txtVolumenMuestra= new JTextField(15);
		txtVolumenMuestra.setEditable(false);
		
		txtVolumenEritrocitos= new JTextField(15);
		txtVolumenEritrocitos.setEditable(false);
		
		txtConteoLeucocitos= new JTextField(15);
		txtConteoLeucocitos.setEditable(false);
		
		txtConteoPlaquetas= new JTextField(15);
		txtConteoPlaquetas.setEditable(false);
		
		
		// configuracion de areas de texto
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
		
		panelMuestra.setLayout(new GridLayout(6, 4));
		panelMuestra.add(labFTomaMuestra);
		panelMuestra.add(txtFTomaMuestra);
		panelMuestra.add(new JLabel(""));
		panelMuestra.add(cbAyunas);
		panelMuestra.add(labVolumenMuestra);
		panelMuestra.add(txtVolumenMuestra);
		panelMuestra.add(labVacio);
		panelMuestra.add(labVacio);
		panelMuestra.add(labVolumenEritrocitos);
		panelMuestra.add(txtVolumenEritrocitos);
		panelMuestra.add(butHematocrito);
		panelMuestra.add(labVacio);
		panelMuestra.add(labConteoLeucocitos);
		panelMuestra.add(txtConteoLeucocitos);
		panelMuestra.add(butLeucocitos);
		panelMuestra.add(labVacio);
		panelMuestra.add(labConteoPlaquetas);
		panelMuestra.add(txtConteoPlaquetas);
		panelMuestra.add(labVacio);
		panelMuestra.add(labVacio);		
	}
	
	public String darVolumenMuestra() {
		String rta = txtVoluMenMuestra.getText();
		return rta;
	}
	
	public String darVolumenEritrocitos() {
		String rta = txtVoluMenMuestra.getText();
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
		txtHematocrito.setText(pHematrocrito + "");
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
								 int pConteoLeucocitos, int pConteoPlaquetas, String pEdad) {
		txtFTomaMuestra.setText(pFechaMuestra);
		txtVolumenMuestra.setText(pVolumenMuestra + "");
		txtVolumenEritrocitos.setText(pVolumenEritrocitos + "");
		txtConteoLeucocitos.setText(pConteoLeucocitos + "");
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
