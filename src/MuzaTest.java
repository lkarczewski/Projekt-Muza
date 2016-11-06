import java.util.Scanner;
import java.io.FileNotFoundException;

public class MuzaTest {
	public static void main(String [] args) throws FileNotFoundException{
		
		StworzBaze op1 = new StworzBaze();
		Filtrowanie op1a = new Filtrowanie();
		Dodawanie op1b = new Dodawanie();
		Wyswietl op2 = new Wyswietl();
		
		Scanner wejscie = new Scanner(System.in);
		int opcja=0;
		int id = 0;
		String wykonawca = null;
		String album = null ;
		int rok = 0;
		
		do{
			System.out.println("POLSKIE NAGRANIA 'MUZA' - BAZA P�YT 1956-1991");
			System.out.println("---------------------------------------------");
			System.out.println("1 - Utw�rz baz� danych");
			System.out.println("2 - Wy�wietl ca�� baz� danych");
			//System.out.println("3 - Usu� baz� danych");
			System.out.println("3 - Wyszukaj wykonawc�");
			System.out.println("4 - Wyszukaj album");
			System.out.println("5 - Wy�wietl wszystkie p�yty z danego roku");
			System.out.println("6 - Wyjd�");
			System.out.println("---------------------------------------------");
			System.out.println("Wprowad� liczb� aby wybra� opcj�:");
			opcja=wejscie.nextInt();
			
			switch(opcja){
			case 1:
				op1.Create();
				op1a.Filter();
				op1b.Add(id,wykonawca,album,rok);
				break;
			case 2:
				op2.Show();
				break;
			case 3:
				System.out.println("Podaj wykonawc�");
				break;
			case 4:
				System.out.println("Podaj nazw� albumu");
				break;
			case 5:
				System.out.println("Podaj rok");
				break;
			case 6:
				System.out.println("Wybra�e� opcj� 6");
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
