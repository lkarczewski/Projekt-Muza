import java.util.Scanner;
import java.io.FileNotFoundException;

public class MuzaTest {
	public static void main(String [] args) throws FileNotFoundException{
		
		StworzBaze op1 = new StworzBaze();
		Filtrowanie op1a = new Filtrowanie();
		Wyswietl op2 = new Wyswietl();
		UsunBaze op3 = new UsunBaze();
		ZnajdzWykonawce op4 = new ZnajdzWykonawce();
		ZnajdzAlbum op5 = new ZnajdzAlbum();
		ZestawienieRoczne op6 = new ZestawienieRoczne();
		
		Scanner wejscie = new Scanner(System.in);
		int opcja=0;
		
		do{
			System.out.println("POLSKIE NAGRANIA 'MUZA' - BAZA P�YT WINYLOWYCH 1956-1991");
			System.out.println("		� �ukasz Karczewski, 2016				");
			System.out.println("--------------------------------------------------------");
			System.out.println("1 - Utw�rz baz� danych");
			System.out.println("2 - Wy�wietl ca�� baz� danych");
			System.out.println("3 - Usu� tabele");
			System.out.println("4 - Wyszukaj wykonawc�");
			System.out.println("5 - Wyszukaj album");
			System.out.println("6 - Wy�wietl wszystkie p�yty z danego roku");
			System.out.println("7 - Wyjd�");
			System.out.println("---------------------------------------------------------");
			System.out.println("�r�d�o: pl.wikipedia.org/Polskie_Nagrania_Muza");
			System.out.println("---------------------------------------------------------");
			System.out.println("Wprowad� liczb� aby wybra� opcj�:");
			opcja=wejscie.nextInt();
			
			switch(opcja){
			case 1:
				System.out.println("Tworz� baz� danych...");
				op1.Create();
				System.out.println("Dodaj� rekordy...");
				op1a.Filter();
				System.out.println("Dodano odfiltrowane dane z pliku");
				break;
			case 2:
				System.out.println("Wy�wietlam tabele...");
				op2.Show();
				break;
			case 3:
				System.out.println("Usuwam tabele...");
				op3.Delete();
				break;
			case 4:
				System.out.println("Podaj wykonawc�");
				op4.FindArtist();
				break;
			case 5:
				System.out.println("Podaj nazw� albumu");
				op5.FindAlbum();
				break;
			case 6:
				System.out.println("Podaj rok");
				op6.DisplayYear();
				break;
			case 7:
				System.out.println("Zako�czono");
				System.exit(0);
				break;
			default:System.out.println("Wprowad� poprawn� liczb�");
			}	
		}while(opcja!=7);
		wejscie.close();
	}
}
