import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:Baza.db";

	private Helper() {
		// klasa w pe³ni statyczna
	}

	/**
	 * Wykonuje zapytanie SQL i wyœwietla rezultat.
	 * 
	 * @param query
	 *            Zapytanie SQL.
	 * @throws SQLException
	 */
	public static void displayRecords(String query) throws SQLException {
		// try-with-resources
		try (Connection conn = DriverManager.getConnection(DB_URL)) {
			try (Statement stmt = conn.createStatement()) {
				try (ResultSet result = stmt.executeQuery(query)) {
					displayRecords(result);
				}
			}

		}
	}

	/**
	 * Wyœwietla rekordy.
	 * 
	 * @param result
	 *            Rezultat wyszukiwania w bazie.
	 * @throws SQLException
	 */
	public static void displayRecords(final ResultSet result) throws SQLException {
		int id;
		String wykonawca;
		String album;
		int rok;
		while (result.next()) {
			id = result.getInt("id");
			wykonawca = result.getString("wykonawca");
			album = result.getString("album");
			rok = result.getInt("rok");
			System.out.format("id=%d, wykonawca=%s, album=%s, rok=%d%n", id, wykonawca, album, rok);
		}
	}

}
