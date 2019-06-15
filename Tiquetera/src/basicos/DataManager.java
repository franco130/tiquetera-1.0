package basicos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.Usuario;

public class DataManager {
	private static DataManager instance;

	private DataManager() {
	}

	public static DataManager getInstance() {
		if (instance == null) {
			instance = new DataManager();
		}
		return instance;
	}

	public void crearUsuario(Usuario unUsuario) {
		String user = unUsuario.getUser();
		String email = unUsuario.getEmail();
		String pass = unUsuario.getPass();
		int type = unUsuario.getType();

		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO usuarios (user, email, pass, type) VALUES ('" + user + "', '" + email + "', '"
					+ pass + "', '" + type + "')";
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				c.rollback();
			} catch (SQLException e1) {
				e.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void borraUsuario(String username) {
		String sql = "DELETE FROM usuarios WHERE user = '" + username + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void actualizaUsuario(Usuario unUsuario) {
		String user = unUsuario.getUser();
		String email = unUsuario.getEmail();
		String pass = unUsuario.getPass();
		// no necesitamos cambiar el tipo

		String sql = "UPDATE usuarios set email = '" + email + "', pass = '" + pass + "' WHERE user = '" + user + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public Usuario getUsuario(String username, String pass) {
		String sql = "SELECT * FROM usuarios WHERE user = '" + username + "' AND pass = '" + pass + "'";
		Connection c = DBManager.connect();
		Usuario user = null;

		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				user = new Usuario(rs.getInt("id"), rs.getString("user"), rs.getString("email"), rs.getString("pass"),
						rs.getInt("type"));
			}
		} catch (SQLException e) {
			// no nos interesa que devuelva error si no puedo encontrarlo, es suficiente con
			// el null
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}
}
