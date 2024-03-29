package basicos;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_BASE_URL = "jdbc:h2:tcp://localhost//{DIR}/practico";
	@SuppressWarnings("unused")
	private static final String DB_NAME = "/tiquetera";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";

	private static DBManager instance;

	private DBManager() {
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public static Connection connect() {
		Connection c = null;
		try {
			Class.forName(DBManager.DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			String url = DB_BASE_URL.replace("{DIR}", obtenerUbicacionBase());
			c = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return c;
	}

	private static String obtenerUbicacionBase() {
		File currDir = new File("h2/base_de_datos/");
		return currDir.getAbsolutePath();
	}

	public static void mostrarUrlParaConsolaWeb() {
		String url = DB_BASE_URL.replace("{DIR}", obtenerUbicacionBase());
		System.out.println("====>> URL PARA COPIAR EN CONSOLA WEB" + url);
	}
}
