package ui;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	private Handler handler;
	private JMenuBar menu;
	private JButton login;
	private JButton logout;
	private JMenuItem showBalance;

	public Ventana(Handler handler, String titulo) {
		this.handler = handler;
		menu = new JMenuBar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 500, 550);
		setTitle(titulo);
		setLocationRelativeTo(null);
		setMenu();
		setVisible(true);
	}

	public void cambiarPanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		getContentPane().validate();
	}
	
	public void setMenu() {
		JMenu usersMenu = new JMenu("Usuarios");
		JMenuItem showAllUsers = new JMenuItem("Listado de Usuarios");
		showAllUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTablaUsuarios();
			}
		});
		usersMenu.add(showAllUsers);
		JMenuItem insertarUsuario = new JMenuItem("Ingresar Nuevo");
		insertarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarAltaUsuario();
			}
		});
		usersMenu.add(insertarUsuario);
		menu.add(usersMenu);
		
		JMenu programasMenu = new JMenu("Programas");
		JMenuItem showProgramas = new JMenuItem("Listado de Programas");
		showProgramas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTablaProgramas();
			}
		});
		programasMenu.add(showProgramas);
		JMenuItem altaPrograma = new JMenuItem("Ingresar Nuevo");
		altaPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarAltaProgramas();
			}
		});
		programasMenu.add(altaPrograma);

		showBalance = new JMenuItem("Mostrar Balance");
		showBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarBalance();
			}
		});
		programasMenu.add(showBalance);
		
		menu.add(programasMenu);
		
		menu.add(Box.createHorizontalGlue());
		menu.add(Box.createHorizontalGlue());
		
		final JButton exitButton = new JButton("Salir");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            Container frame = exitButton.getParent();
	            do {
	                frame = frame.getParent();
	            }
	            while(!(frame instanceof JFrame));
	            ((JFrame) frame).dispose();
			 }
		});
		menu.add(exitButton);
		
		login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarLogin();
			}
		});
		menu.add(login);
		logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.logout();
			}
		});
		menu.add(logout);
		refreshButtons();
		setJMenuBar(menu);
	}
	
	public void refreshButtons() {
		login.setVisible(handler.getLogged() == null);
		logout.setVisible(handler.getLogged() != null);
		showBalance.setVisible(handler.isLoggedProducer());
	}
}
