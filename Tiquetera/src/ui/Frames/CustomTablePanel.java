package ui.Frames;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public abstract class CustomTablePanel extends JPanel {
	protected JTable tabla;
	protected ui.Handler handler;
	protected JButton botonDelete;
	protected JButton botonSeeMore;
	protected JButton editButton;
	protected Box vertical;
	protected AbstractTableModel model;

	public CustomTablePanel(ui.Handler handler) {
		this.handler = handler;
		tabla = new JTable();
	}
	
	protected void start(String name) {
		vertical = Box.createVerticalBox();
		setTitle(name);
	}
	
	protected void setTitle(String title) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titulo = BorderFactory.createTitledBorder(blackline, title);
		titulo.setTitleJustification(TitledBorder.CENTER);
		vertical.setBorder(new CompoundBorder(titulo, new EmptyBorder(10,10,10,10)));
	}

	public void setModel(AbstractTableModel model) {
		this.model = model;
		modelling();
	}
	
	public void modelling() {
		tabla = new JTable(model);
		add(new JScrollPane(tabla));
	}
	
	protected abstract void deleteButtonAction();
	protected abstract void editButtonAction();
	protected abstract void seeMoreButtonAction();
	
	public void addDeleteButton() {
		botonDelete = new JButton("Eliminar Seleccionado");
		botonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteButtonAction();
			}
		});
		botonDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(botonDelete);
	}
	
	public void addSeeMoreButton() {
		botonSeeMore = new JButton("Ver Datos");
		botonSeeMore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seeMoreButtonAction();
			}
		});
		botonSeeMore.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(botonSeeMore);
	}
	
	public void addEditButton() {
		editButton = new JButton("Editar");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editButtonAction();
			}
		});
		editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(editButton);
	}
	
	public Box getVertical() {
		return vertical;
	}

	public void setVertical(Box vertical) {
		this.vertical = vertical;
	}
}
