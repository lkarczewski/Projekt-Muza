import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZnajdzAlbum {
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:Baza.db";

	private static Connection conn;
	private static Statement stmt;

	void FindAlbum(Scanner wejscie) {

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

		System.out.println("Podaj album:");
		// Scanner input = new Scanner(System.in);
		String record = wejscie.nextLine();

		try {
			conn = DriverManager.getConnection(DB_URL);
			ResultSet result = stmt.executeQuery("SELECT * FROM plyta WHERE album='" + record + "';");
			int id;
			String wykonawca;
			int rok;
			while (result.next()) {
				id = result.getInt("id");
				wykonawca = result.getString("wykonawca");
				rok = result.getInt("rok");
				System.out.println("id=" + id + ", wykonawca=" + wykonawca + ",album=" + record + ",rok=" + rok++);
			}
		}

		catch (SQLException e) {
			System.err.println("Blad przy wykonywaniu SELECT");
			e.printStackTrace();
		}
	}

}
