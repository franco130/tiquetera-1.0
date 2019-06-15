package ui.Frames.Usuarios;
import java.util.List;
import modelos.Usuario;
import ui.Handler;
import ui.Frames.CustomTablePanel;
import ui.Model.UsuariosTableModel;

@SuppressWarnings("serial")
public class UsuariosTablePanel extends CustomTablePanel {
	private List<Usuario> usuarios;
	
	public UsuariosTablePanel(Handler handler) {
		super(handler);
		initUI();
	}
	
	public void initUI () {
		start("Listado de Usuarios");
		try {
			usuarios = handler.getUsuarioBO().get();
			super.setModel(new UsuariosTableModel(usuarios));
		} catch (Exception e) {
			handler.showError(e);
		}
		addDeleteButton();
		addSeeMoreButton();
		addEditButton();
	}

	@Override
	protected void deleteButtonAction() {
		int row = tabla.getSelectedRow();
		if (row < 0) {
			handler.showMessage("Seleccione una fila!");
		} else {
			Usuario u = ((UsuariosTableModel) super.tabla.getModel()).getUsuario(row);
			handler.deleteUsuario(u);
		}	
		
	}

	@Override
	protected void editButtonAction() {
		int seleccionado = super.tabla.getSelectedRow();
		Usuario u = new Usuario();
		u = usuarios.get(seleccionado);
		handler.mostrarModificarUsuario(u);
	}

	@Override
	protected void seeMoreButtonAction() {
		int row = super.tabla.getSelectedRow();
		if (row < 0) {
			handler.showMessage("Seleccione una fila!");
		} else {
			Usuario u = ((UsuariosTableModel) super.tabla.getModel()).getUsuario(row);
			handler.showMessage(u.toString());
		}
	}
}
