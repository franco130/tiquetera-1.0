package ui.Frames.Usuarios;
import modelos.Usuario;
import ui.Handler;

@SuppressWarnings("serial")
public class UpdateUsuario extends UsuarioPanel {
	public UpdateUsuario (Handler handler, Usuario user) {
		super(handler);
		updateValues(user);
	}
	
	@Override
	public void initUI() {
		super.initUI();
	}

	public void updateValues(Usuario user) {
		emailTF.setText(user.getEmail());
		emailTF.setEditable(false);
		typeCB.setSelectedIndex(user.getType());
		userTF.setText(user.getUser());
		userTF.setEditable(false);
		passTF.setText(user.getPass());

	}
	
	@Override
	protected void altaButtonAction() {
		Usuario u = getData();
		handler.modificarUsuario(u);
	}
}
