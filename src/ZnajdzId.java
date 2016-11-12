import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZnajdzId {
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:Baza.db";

	private static Connection conn;
	private static Statement stmt;

	void FindId(Scanner wejscie) {

		// try {
		// Class.forName(DRIVER);
		// } catch (ClassNotFoundException e) {
		// System.err.println("Brak sterownika JDBC");
		// e.printStackTrace();
		// }

		try {
			conn = DriverManager.getConnection(DB_URL);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem połączenia");
			e.printStackTrace();
		}

		System.out.println("Podaj id:");
		// Scanner input = new Scanner(System.in);
		int catnum = wejscie.nextInt();

		try {
			conn = DriverManager.getConnection(DB_URL);
			ResultSet result = stmt.executeQuery("SELECT * FROM plyta WHERE id='" + catnum + "';");
			String wykonawca;
			String album;
			int rok;
			while (result.next()) {
				wykonawca = result.getString("wykonawca");
				album = result.getString("album");
				rok = result.getInt("rok");
				System.out.println("id=" + catnum + ", wykonawca=" + wykonawca + ",album=" + album + ",rok=" + rok++);
			}
		}

		catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu SELECT");
			e.printStackTrace();
		}
	}

}
