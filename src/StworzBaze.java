import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StworzBaze {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:Baza.db";

	private static Connection conn;
	private static Statement stmt;

	void Create() {

		// dodaje klase JDBC
		// try {
		// Class.forName(DRIVER);
		// } catch (ClassNotFoundException e) {
		// System.err.println("Brak sterownika JDBC");
		// e.printStackTrace();
		// }

		// nawiazuje polaczenie z baza danych
		try {
			conn = DriverManager.getConnection(DB_URL);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem po��czenia");
			e.printStackTrace();
		}

		// tworze tabele
		String createPlyta = "CREATE TABLE IF NOT EXISTS plyta(id INTEGER, wykonawca TEXT, album TEXT, rok INTEGER);";
		try {
			stmt.execute(createPlyta);

		} catch (SQLException e) {
			System.err.println("Blad przy tworzeniu tabeli");
			e.printStackTrace();
		}
		System.out.println("Utworzono baz� danych");
	}
}
