import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsunBaze {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:Baza.db";

	private static Connection conn;
	private static Statement stmt;

	void Delete() {
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
			System.err.println("Problem z otwarciem po³¹czenia");
			e.printStackTrace();
		}

		String deletePlyta = "DROP TABLE plyta;";
		try {
			stmt.execute(deletePlyta);

		} catch (SQLException e) {
			System.err.println("Blad przy usuwaniu tabeli");
			e.printStackTrace();
		}
		System.out.println("Usuniêto tabele");

	}

}
