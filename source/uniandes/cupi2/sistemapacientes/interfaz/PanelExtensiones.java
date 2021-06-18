package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel implements ActionListener{
	
	private InterfazSistemaPacientes principal;
	
	private static final String AVANZAR = "AVANZAR";
	private static final String RETROCEDER = "RETROCEDER";
	private static final String OPCION_1 = "opcion1";
	private static final String OPCION_2 = "opcion2";
	
	private JButton btnAvanzar;
	private JButton btnRetroceder;
	
	private JButton butOpcion1;
	private JButton butOpcion2;

	public PanelExtensiones(InterfazSistemaPacientes v) {
		principal = v;
		
		setLayout(new FlowLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Puntos de extensión");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		btnRetroceder = new JButton("<");
		btnRetroceder.setActionCommand(RETROCEDER);
		add(btnRetroceder);
		
		butOpcion1 = new JButton("Opción 1");
		butOpcion1.setActionCommand(OPCION_1);
		add(butOpcion1);
		
		butOpcion2 = new JButton("Opción 2");
		butOpcion2.setActionCommand(OPCION_2);
		add(butOpcion2);
		
		btnAvanzar = new JButton(">");
		btnAvanzar.setActionCommand(AVANZAR);
		add(btnAvanzar);
		
		btnRetroceder.addActionListener(this);
		butOpcion1.addActionListener(this);
		butOpcion2.addActionListener(this);
		btnAvanzar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(AVANZAR)){
			principal.avanzar();
		} else if(comando.equals(RETROCEDER)) {
			principal.retroceder();
		} else if(comando.equals(OPCION_1)) {
			principal.reqFuncOpcion1();
		} else if(comando.equals(OPCION_2)) {
			principal.reqFuncOpcion2();
		}
	}
}
