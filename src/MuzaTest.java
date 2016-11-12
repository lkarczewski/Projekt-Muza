import java.util.Scanner;
import java.io.FileNotFoundException;

public class MuzaTest {
	public static void main(String [] args) throws FileNotFoundException {
		
		StworzBaze op1 = new StworzBaze();
		Filtrowanie op1a = new Filtrowanie();
		Wyswietl op2 = new Wyswietl();
		WyszukajMenu op4 = new WyszukajMenu();
		UsunBaze op3 = new UsunBaze();
		ZnajdzRok op5 = new ZnajdzRok();
		ZestawieniaMenu op6 = new ZestawieniaMenu();
		
		Scanner wejscie = new Scanner(System.in);
		int opcja = 0;
		
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
			opcja=wejscie.nextInt();
			
			switch(opcja) {
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
				op4.SearchMenu();
			case 5:
				op5.DisplayYear();
				break;
			case 6:
				op6.JuxMenu();
			case 7:
				System.out.println("Zakoñczono");
				System.exit(0);
				break;
			default:System.out.println("WprowadŸ poprawn¹ liczbê");
			}	
		}while(opcja!=7);
		wejscie.close();
	}
}
