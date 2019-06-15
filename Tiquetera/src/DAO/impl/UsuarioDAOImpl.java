package DAO.impl;

import exceptions.Excepcion;
import modelos.Usuario;
import basicos.DataManager;

public class UsuarioDAOImpl implements DAO.UsuarioDAO { 

	@Override
	public static void add(Usuario user) throws Excepcion {
		try {
			DataManager.getInstance().crearUsuario(user);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public static void update(Usuario user) throws Excepcion {
		try {
			DataManager.getInstance().actualizaUsuario(user);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public static Usuario get(String user, String pass) throws Excepcion {
		return DataManager.getInstance().getUsuario(user, pass);
	}

}
