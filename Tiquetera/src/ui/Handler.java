package ui;
import javax.swing.JOptionPane;
import exceptions.*;
import DAO.impl.*;
import modelos.*;
import ui.Frames.*;
import ui.Frames.Programas.*;
import ui.Frames.Usuarios.*;

public class Handler implements EventsManager {
	private Ventana frame;

	public Handler() {
		frame = new Ventana(this, "Tiquetera");
	}

	//General
	public void init() {
		mostrarLogin();
	}
	@Override
	public void back() {
		frame.cambiarPanel(new EmptyPanel(this));
	}
	@Override
	public void mostrarPanelPrincipal() {
		frame.cambiarPanel(new EmptyPanel(this));
	}
	@Override
	public void showError(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	//Usuarios
	public void mostrarAltaUsuario() {
		frame.cambiarPanel(new UsuarioPanel(this));
	}
	public void mostrarLogin() {
		frame.cambiarPanel(new LoginPanel(this));
	}
	public void mostrarModificarUsuario(Usuario u) {
		frame.cambiarPanel(new UpdateUsuario(this, u));
	}


	public void altaUsuario(Usuario u) {
		try {
			UsuarioDAOImpl.add(u);
			showMessage("El Usuario ha sido agregado exitosamente.");
		} catch (Excepcion e) {
			showError(e);
		}
	}

	// Login Logic
	public void login(String usuario, String password) {
		try {
			Usuario user = UsuarioDAOImpl.get(usuario, password);
			frame.refreshButtons();
			showMessage("Inicio su sesion exitosamente.");
			frame.cambiarPanel(new EmptyPanel(this));
		} catch (Excepcion e) {
			showError(new Excepcion("Usuario no encontrado"));
		}
	}

	public void logout() {
		getUsuarioBO().logout();
		showMessage("Cerr� su sesi�n exitosamente.");
		mostrarLogin();
	}

	public Usuario getLogged() {
		return getUsuarioBO().getLogged();
	}

	public boolean isLoggedProducer() {
		return getUsuarioBO().isProducer();
	}
}
