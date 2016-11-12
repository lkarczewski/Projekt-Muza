import java.util.Scanner;

public class WyszukajMenu {
	
	void SearchMenu(){
	
		ZnajdzId op4a = new ZnajdzId();
		ZnajdzWykonawce op4b = new ZnajdzWykonawce();
		ZnajdzAlbum op4c = new ZnajdzAlbum();
	
		Scanner wejscie = new Scanner(System.in);
		int opcja = 0;
	
		while(opcja!=4) {
			System.out.println("-----------WYSZUKAJ-----------");
			System.out.println("1 - Wyszukaj id");
			System.out.println("2 - Wyszukaj wykonawcê");
			System.out.println("3 - Wyszukaj album");
			System.out.println("4 - Wróc do g³ównego menu");
			System.out.println("------------------------------");
			opcja=wejscie.nextInt();
			
			switch(opcja){
			case 1:
				op4a.FindId();
				break;
			case 2:
				op4b.FindArtist();
				break;
			case 3:
				op4c.FindAlbum();
				break;
			case 4:
				return;
			default:System.out.println("WprowadŸ poprawn¹ liczbê");
		}
	}
		
	wejscie.close();

	}
}