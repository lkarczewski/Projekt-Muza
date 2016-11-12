import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MuzaTest {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:Baza.db";

	public static void main(String[] args) throws FileNotFoundException, SQLException {

		// Sprawdzenie obecnoœci sterownika JDBC
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Brak sterownika JDBC", e);
		}
		// Utworzenie wymaganych obiektów
		StworzBaze op1 = new StworzBaze();
		Filtrowanie op1a = new Filtrowanie();
		Wyswietl op2 = new Wyswietl();
		WyszukajMenu op4 = new WyszukajMenu();
		UsunBaze op3 = new UsunBaze();
		ZnajdzRok op5 = new ZnajdzRok();
		ZestawieniaMenu op6 = new ZestawieniaMenu();
		// Komunikacja z u¿ytkownikiem
		Scanner wejscie = new Scanner(System.in);
		int opcja = 0;

		// G³ówna pêtla programu
		do {
			System.out.println("POLSKIE NAGRANIA 'MUZA' - BAZA P£YT WINYLOWYCH 1956-1991");
			System.out.println("		© £ukasz Karczewski, 2016				");
			System.out.println("--------------------------------------------------------");
			System.out.println("1 - Utwórz bazê danych");
			System.out.println("2 - Wyœwietl ca³¹ bazê danych");
			System.out.println("3 - Usuñ tabele");
			System.out.println("4 - Wyszukaj...");
			System.out.println("5 - Wyœwietl wszystkie p³yty z danego roku");
			System.out.println("6 - Zestawienia...");
			System.out.println("7 - WyjdŸ");
			System.out.println("---------------------------------------------------------");
			System.out.println("Ÿród³o: pl.wikipedia.org/Polskie_Nagrania_Muza");
			System.out.println("---------------------------------------------------------");
			System.out.println("WprowadŸ liczbê aby wybraæ opcjê:");
			// Wczytanie numeru opcji
			try {
				opcja = wejscie.nextInt();
			} catch (InputMismatchException e) {
				opcja = 0;
			}
			// Przeczytanie koñca linii po cyfrze lub przeczytanie ca³ej b³êdnej
			// linii
			wejscie.nextLine();

			switch (opcja) {
			case 1:
				System.out.println("Tworzê bazê danych...");
				op1.Create();
				System.out.println("Dodajê rekordy...");
				op1a.Filter();
				System.out.println("Dodano odfiltrowane dane z pliku");
				break;
			case 2:
				System.out.println("Wyœwietlam tabele...");
				op2.Show();
				break;
			case 3:
				System.out.println("Usuwam tabele...");
				op3.Delete();
				break;
			case 4:
				op4.SearchMenu(wejscie);
				break;
			case 5:
				op5.displayYear(wejscie);
				break;
			case 6:
				op6.JuxMenu();
			case 7:
				System.out.println("Zakoñczono");
				System.exit(0);
				break;
			default:
				System.out.println("WprowadŸ poprawn¹ liczbê");
			}
		} while (opcja != 7);
		// Zamyka skaner i strumieñ standardowy
		wejscie.close();
	}

}