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
			System.out.println("POLSKIE NAGRANIA 'MUZA' - BAZA P£YT 1956-1991");
			System.out.println("---------------------------------------------");
			System.out.println("1 - Utwórz bazê danych");
			System.out.println("2 - Wyœwietl ca³¹ bazê danych");
			//System.out.println("3 - Usuñ bazê danych");
			System.out.println("3 - Wyszukaj wykonawcê");
			System.out.println("4 - Wyszukaj album");
			System.out.println("5 - Wyœwietl wszystkie p³yty z danego roku");
			System.out.println("6 - WyjdŸ");
			System.out.println("---------------------------------------------");
			System.out.println("WprowadŸ liczbê aby wybraæ opcjê:");
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
				System.out.println("Podaj wykonawcê");
				break;
			case 4:
				System.out.println("Podaj nazwê albumu");
				break;
			case 5:
				System.out.println("Podaj rok");
				break;
			case 6:
				System.out.println("Wybra³eœ opcjê 6");
				break;
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
