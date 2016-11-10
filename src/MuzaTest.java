import java.util.Scanner;
import java.io.FileNotFoundException;

public class MuzaTest {
	public static void main(String [] args) throws FileNotFoundException {
		
		StworzBaze op1 = new StworzBaze();
		Filtrowanie op1a = new Filtrowanie();
		Wyswietl op2 = new Wyswietl();
		UsunBaze op3 = new UsunBaze();
		ZnajdzId op4a = new ZnajdzId();
		ZnajdzWykonawce op4b = new ZnajdzWykonawce();
		ZnajdzAlbum op4c = new ZnajdzAlbum();
		ZnajdzRok op6 = new ZnajdzRok();
		
		Scanner wejscie = new Scanner(System.in);
		Scanner wejscie2 = new Scanner(System.in);
		Scanner wejscie3 = new Scanner(System.in);
		int opcja = 0;
		int opcja2 = 0;
		int opcja3 = 0;
		
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
				do {
					System.out.println("-----------WYSZUKAJ-----------");
					System.out.println("1 - Wyszukaj id");
					System.out.println("2 - Wyszukaj wykonawcê");
					System.out.println("3 - Wyszukaj album");
					System.out.println("4 - Wróc do g³ównego menu");
					System.out.println("------------------------------");
					opcja2=wejscie.nextInt();
						switch(opcja2){
						case 1:
							op4a.FindId();
			s				break;
						case 2:
							op4b.FindArtist();
							break;
						case 3:
							op4c.FindAlbum();
							break;
						case 4:
							break;
						default:System.out.println("WprowadŸ poprawn¹ liczbê");
					}
				}
				while(opcja2!=4);
				wejscie2.close();
				break;
			case 5:
				op6.DisplayYear();
				break;
			case 6:
				do {
					System.out.println("-----------ZESTAWIENIA----------------------------------------------------------");
					System.out.println("1 - Iloœæ p³yt wydanych przez poszczególnych wykonawców w latach 1956-1990");
					System.out.println("2 - Iloœæ p³yt wydanych w latach 1956-1990");
					System.out.println("--------------------------------------------------------------------------------");
					opcja3=wejscie3.nextInt();
					switch(opcja3) {
					case 1:
						System.out.println("Wybra³eœ opcje 1");
						break;
					case 2:
						System.out.println("Wybra³eœ opcje 2");
						break;
					}
				}
				while(opcja3!=2);
				wejscie3.close();
				break;
			case 7:
				System.out.println("Zakoñczono");
				System.exit(0);
				break;
			default:System.out.println("WprowadŸ poprawn¹ liczbê");
			}	
		}while(opcja!=6);
		wejscie.close();
	}
}
