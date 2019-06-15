package ui;

public interface EventsManager {
	//General
	public void back();
	public void showError(Exception e);
	public void mostrarPanelPrincipal();

	//User Related
	public void mostrarLogin() throws Exception;
	public void mostrarAltaUsuario();

}
