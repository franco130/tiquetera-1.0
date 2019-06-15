package DAO;
import modelos.Usuario;
import exceptions.Excepcion;

public interface UsuarioDAO {
	public void add (Usuario user) throws Excepcion;
	public void update (Usuario user) throws Excepcion; 
	public Usuario get (String user, String pass) throws Excepcion;
}
