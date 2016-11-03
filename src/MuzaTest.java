import java.util.Scanner;

public class MuzaTest {
	public static void main(String [] args){
		
		Scanner wejscie = new Scanner(System.in);
		int opcja=0;
		
		do{
			System.out.println("POLSKIE NAGRANIA 'MUZA' - BAZA P�YT 1956-1991");
			System.out.println("---------------------------------------------");
			System.out.println("1 - Utw�rz baz� danych z pliku");
			System.out.println("2 - Wy�wietl ca�� baz� danych");
			System.out.println("3 - Usu� baz� danych");
			System.out.println("4 - Wyszukaj wykonawc�");
			System.out.println("5 - Wyszukaj album");
			System.out.println("6 - Wy�wietl wszystkie p�yty z danego roku");
			System.out.println("7 - Wyjd�");
			System.out.println("---------------------------------------------");
			System.out.println("Wprowad� liczb� aby wybra� opcj�:");
			opcja=wejscie.nextInt();
			
			switch(opcja){
			case 1:
				System.out.println("Utworzono baz� danych");
				break;
			case 2:
				System.out.println("Usuni�to baz� danych");
				break;
			case 3:
				System.out.println("Wybra�e� opcj� 3");
				break;
			case 4:
				System.out.println("Wybra�e� opcj� 4");
				break;
			case 5:
				System.out.println("Wybra�e� opcj� 5");
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
