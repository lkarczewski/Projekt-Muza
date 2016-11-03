import java.util.Scanner;

public class MuzaTest {
	public static void main(String [] args){
		
		Scanner wejscie = new Scanner(System.in);
		int opcja=0;
		
		do{
			System.out.println("POLSKIE NAGRANIA 'MUZA' - BAZA P£YT 1956-1991");
			System.out.println("---------------------------------------------");
			System.out.println("1 - Utwórz bazê danych z pliku");
			System.out.println("2 - Wyœwietl ca³¹ bazê danych");
			System.out.println("3 - Usuñ bazê danych");
			System.out.println("4 - Wyszukaj wykonawcê");
			System.out.println("5 - Wyszukaj album");
			System.out.println("6 - Wyœwietl wszystkie p³yty z danego roku");
			System.out.println("7 - WyjdŸ");
			System.out.println("---------------------------------------------");
			System.out.println("WprowadŸ liczbê aby wybraæ opcjê:");
			opcja=wejscie.nextInt();
			
			switch(opcja){
			case 1:
				System.out.println("Utworzono bazê danych");
				break;
			case 2:
				System.out.println("Usuniêto bazê danych");
				break;
			case 3:
				System.out.println("Wybra³eœ opcjê 3");
				break;
			case 4:
				System.out.println("Wybra³eœ opcjê 4");
				break;
			case 5:
				System.out.println("Wybra³eœ opcjê 5");
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
