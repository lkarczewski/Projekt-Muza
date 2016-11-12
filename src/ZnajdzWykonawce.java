import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZnajdzWykonawce {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:Baza.db";

	private static Connection conn;
	private static Statement stmt;

	void FindArtist(Scanner wejscie) {

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
			System.err.println("Problem z otwarciem po³¹czenia");
			e.printStackTrace();
		}

		System.out.println("Podaj wykonawcê:");
		// Scanner input = new Scanner(System.in);
		String artist = wejscie.nextLine();

		// java.util.regex.Pattern p;
		// input.close();

		try {
			// conn = DriverManager.getConnection(DB_URL);
			ResultSet result = stmt.executeQuery("SELECT * FROM plyta WHERE wykonawca='" + artist + "';");
			int id;
			String album;
			int rok;
			while (result.next()) {
				id = result.getInt("id");
				album = result.getString("album");
				rok = result.getInt("rok");
				System.out.println("id=" + id + ", wykonawca=" + artist + ",album=" + album + ",rok=" + rok++);
			}
			// conn.close();

		}

		catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu SELECT");
			e.printStackTrace();
		}
	}

}
