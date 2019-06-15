package ui.Frames.Usuarios;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelos.Usuario;
import ui.Handler;
import ui.Frames.CustomPanel;

@SuppressWarnings("serial")
public class UsuarioPanel extends CustomPanel {
	protected JTextField emailTF;
	protected JComboBox<String> typeCB;
	protected JTextField userTF;
	protected JPasswordField passTF;

	
	public UsuarioPanel(Handler handler) {
		super(handler);
	}
	
	@Override
	public void setPanel() {
		start("Nuevo Usuario");
	}
	
	@Override
	protected void setDimension() {
		size = new Dimension(150, 15);
	}
	

	@Override
	public void initUI() {
		emailTF = new JTextField(15);
		createTextFieldRow("Email", emailTF);
		vertical.add(Box.createVerticalStrut(15));
		
		String[] options = { "Administrador", "Vendedor", "Comprador" };
		typeCB = new JComboBox<String>(options);
		createComboBoxRow("Tipo", typeCB);
		vertical.add(Box.createVerticalStrut(15));
		
		userTF = new JTextField(15);
		createTextFieldRow("Usuario", userTF);
		vertical.add(Box.createVerticalStrut(15));
		
		passTF = new JPasswordField(20);
		createPassFieldRow("Password", passTF);
		vertical.add(Box.createVerticalStrut(15));
		
		addAltaButton();
		add(vertical);
	}
	
	public Usuario getData() {
		if (emailTF.getText() != "") {
			Usuario user = new Usuario();
			user.setEmail(emailTF.getText());
			int tipo = 0;
			switch (typeCB.getSelectedItem().toString()) {
			case "Administrador":
				tipo = 0;
				break;
			case "Vendedor":
				tipo = 1;
				break;
			case "Comprador":
				tipo = 2;
				break;
			};
			user.setType(tipo);
			user.setUser(userTF.getText());
			user.setPass(String.valueOf(passTF.getPassword()));
			return user;
		} else {
			return null;
		}
	}

	@Override
	protected void altaButtonAction() {
		Usuario user = getData();
		if (user != null) {
			handler.altaUsuario(user);
		} else {
			handler.showMessage("El usuario no se pudo cargar. Revise los datos ingresados");
		}
		
	}
}
