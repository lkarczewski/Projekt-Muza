import java.sql.SQLException;
import java.util.Scanner;

/**
 * Wyszukuje rekordy na podstawie podanego roku.
 * 
 * @author £ukasz
 *
 */
public class ZnajdzRok {

	void displayYear(Scanner wejscie) throws SQLException {
		System.out.println("Podaj rok:");
		int year = wejscie.nextInt();
		Helper.displayRecords("SELECT * FROM plyta WHERE rok='" + year + "';");
	}

}
