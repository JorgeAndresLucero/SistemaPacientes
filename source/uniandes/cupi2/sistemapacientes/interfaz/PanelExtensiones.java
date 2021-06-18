package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel{
	
	private JButton btnAvanzar;
	private JButton btnRetroceder;
	
	private JButton butOpcion1;
	private JButton butOpcion2;

	public PanelExtensiones() {
		setLayout(new FlowLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Puntos de extensi�n");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		btnRetroceder = new JButton("<");
		add(btnRetroceder);
		
		butOpcion1 = new JButton("Opci�n 1");
		add(butOpcion1);
		
		butOpcion2 = new JButton("Opci�n 2");
		add(butOpcion2);
		
		btnAvanzar = new JButton(">");
		add(btnAvanzar);
		
	}
}
