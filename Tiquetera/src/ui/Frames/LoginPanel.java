package ui.Frames;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ui.Handler;

@SuppressWarnings("serial")
public class LoginPanel extends CustomPanel {
	private JTextField userText;
	private JPasswordField passwordText;

	public LoginPanel(Handler handler) {
		super(handler);
	}
	
	@Override
	protected void setDimension() {
		size = new Dimension(120, 15);
	}
	
	public void setPanel() {
		start("Login");
	}

	protected void initUI() {
		userText = new JTextField(15);
		createTextfieldRow("Usuario: ", userText);
		vertical.add(Box.createVerticalStrut(15));

		passwordText = new JPasswordField(20);
		createPassFieldRow("Password: ", passwordText);
		vertical.add(Box.createVerticalStrut(15));

		JButton registerButton = new JButton("Registrarse");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarAltaUsuario();
			}
		});
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					handler.login(userText.getText(), String.valueOf(passwordText.getPassword()));
				} catch (Exception e1) {
					handler.showError(e1);
				}
				resetLogin();
			}
		});

		ArrayList<JButton> botones = new ArrayList<JButton>();
		botones.add(registerButton);
		botones.add(loginButton);
		createButtonBox(botones);
		
		add(vertical);
	}
	
	private void resetLogin() {
		userText.setText("");
		passwordText.setText("");
	}

	@Override
	protected void altaButtonAction() {}

	
}
