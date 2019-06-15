package ui.Frames;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public abstract class CustomPanel extends JPanel {
	protected ui.Handler handler;
	protected Box vertical;
	protected Dimension size;
	protected JButton altaButton;
	
	public CustomPanel(ui.Handler handler) {
		this.handler = handler;
		setUp();
	}
	
	protected abstract void setDimension();
	protected abstract void setPanel();
	protected abstract void initUI();
	protected abstract void altaButtonAction();
	
	protected void setUp() {
		setDimension();
		setPanel();
		initUI();
	}

	protected void start(String name) {
		Box vertical = Box.createVerticalBox();
		this.vertical = vertical;
		setTitle(name);
	}
	
	protected void setTitle(String title) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titulo;
		titulo = BorderFactory.createTitledBorder(blackline, title);
		titulo.setTitleJustification(TitledBorder.CENTER);
		vertical.setBorder(new CompoundBorder(titulo, new EmptyBorder(10,10,10,10)));
	}

	protected JLabel makeLabel(String label) {
		JLabel inputLabel = new JLabel(label + ": ");
		Dimension dimension = this.size;
		inputLabel.setMinimumSize(dimension);
		inputLabel.setPreferredSize(dimension);
		inputLabel.setMaximumSize(dimension);
		return inputLabel; 
	}
	
	protected void createButtonBox(ArrayList<JButton> botones) {
		Box horizontal = Box.createHorizontalBox();
		for (JButton boton : botones) {
			horizontal.add(boton);
			horizontal.add(Box.createHorizontalStrut(10));
		}
		vertical.add(horizontal);
	}
	
	protected void createSpinnerRow(String label, JSpinner spinner) {
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(makeLabel(label));
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(spinner);
		vertical.add(horizontal);
	}
	
	protected void createTextFieldRow(String label, JTextField textfield) {
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(makeLabel(label));
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(textfield);
		vertical.add(horizontal);
	}
	
	protected void createPassFieldRow(String label, JPasswordField passField) {
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(makeLabel(label));
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(passField);
		vertical.add(horizontal);
	}
	
	protected void createComboBoxRow(String label, JComboBox<String> comboField) {
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(makeLabel(label));
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(comboField);
		vertical.add(horizontal);
	}
	
	protected void createTextfieldRow(String label, JTextField textfield) {
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(makeLabel(label));
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(textfield);
		vertical.add(horizontal);
	}
	
	protected List<String> stringToList(String lista) {
		return Arrays.asList(lista.split("\\s*,\\s*"));
	}
	
	protected String cleanString(List<String> input) {
		StringBuilder builder = new StringBuilder();
		for (String value : input) {
		    builder.append(value);
		}
		return builder.toString();
	}

	public void addAltaButton() {
		altaButton = new JButton("Agregar");
		altaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaButtonAction();
			 }
		});
		altaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		vertical.add(altaButton);
	}
}
