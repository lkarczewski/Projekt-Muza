import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Filtrowanie {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:Baza.db";

	private static Connection conn;
	private static Statement stmt;

	void Filter() throws FileNotFoundException {

		// try {
		// Class.forName(DRIVER);
		// } catch (ClassNotFoundException e) {
		// System.err.println("Brak sterownika JDBC");
		// e.printStackTrace();
		// }

		try {
			conn = DriverManager.getConnection(DB_URL);
			setStmt(conn.createStatement());
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem po��czenia");
			e.printStackTrace();
		}

		Dodawanie dodaj = new Dodawanie();
		File Plik = new File("src//Polskie Nagrania Muza.txt");

		FileInputStream fstream = new FileInputStream(Plik);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		try {
			while ((strLine = br.readLine()) != null) {
				String[] rekord = strLine.split(";", -1);
				dodaj.Add(Integer.parseInt(rekord[0]), rekord[1], rekord[2], Integer.parseInt(rekord[3]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Statement getStmt() {
		return stmt;
	}

	public static void setStmt(Statement stmt) {
		Filtrowanie.stmt = stmt;
	}
}