package ui.Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelos.Usuario;

public class UsuariosTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private final static int LEGAJO = 0;
	private final static int NOMBRE = 1;
	private final static int TIPO = 2;
	private final static int USERNAME = 3;
	// private final static int PASSWORD = 4;
	private final static int INGRESOS = 4;
	private final static int EGRESOS = 5;
	private String[] titulos = new String[] { "Legajo", "Nombre", "Rol", "Username", "Ingresos", "Egresos" };
	private List<Usuario> usuarios;

	public UsuariosTableModel(List<Usuario> usuarios) {
		this.setUsuarios(usuarios);
	}

	@Override
	public String getColumnName(int col) {
		return titulos[col];
	}

	public int getColumnCount() {
		return titulos.length;
	}

	public int getRowCount() {
		return usuarios.size();
	}

	public Object getValueAt(int row, int column) {
		Usuario u = getUsuario(row);
		switch (column) {
			case LEGAJO:
				return u.getLegajo();
			case NOMBRE:
				return u.getNombre();
			case TIPO: {
				switch (u.getTipo()) {
					case 0:
						return "";
					case 1:
						return "Conductor";
					case 2:
						return "Productor";
					case 3:
						return "Auspiciante";
				}
		}
		case USERNAME:
			return u.getUsername();
		case INGRESOS:
			return u.getIngresos();
		case EGRESOS:
			return u.getEgresos();
		}
		return null;
	}

	public Usuario getUsuario(int index) {
		return this.usuarios.get(index);
	}

	private void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
