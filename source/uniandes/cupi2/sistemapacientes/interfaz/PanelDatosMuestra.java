package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelDatosMuestra extends JPanel {
	public PanelDatosMuestra() {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Informaci�n muestra");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
	}
}
