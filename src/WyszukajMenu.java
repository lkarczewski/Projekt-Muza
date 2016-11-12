import java.util.InputMismatchException;
import java.util.Scanner;

public class WyszukajMenu {

	void SearchMenu(Scanner wejscie) {

		ZnajdzId op4a = new ZnajdzId();
		ZnajdzWykonawce op4b = new ZnajdzWykonawce();
		ZnajdzAlbum op4c = new ZnajdzAlbum();

		// Scanner wejscie = new Scanner(System.in);
		int opcja = 0;

		while (opcja != 4) {
			System.out.println("-----------WYSZUKAJ-----------------");
			System.out.println("1 - Wyszukaj id");
			System.out.println("2 - Wyszukaj wykonawcê");
			System.out.println("3 - Wyszukaj album");
			System.out.println("4 - Wróc do g³ównego menu");
			System.out.println("------------------------------------");
			System.out.println("WprowadŸ liczbê aby wybraæ opcjê:");
			try {
				opcja = wejscie.nextInt();
			} catch (InputMismatchException e) {
				// wejscie.nextLine(); // przeczytaj wadliw¹ liniê
				opcja = 0;
			}
			wejscie.nextLine(); // przeczytanie koñca linii po cyfrze

			switch (opcja) {
			case 1:
				op4a.FindId(wejscie);
				break;
			case 2:
				op4b.FindArtist(wejscie);
				break;
			case 3:
				op4c.FindAlbum(wejscie);
				break;
			case 4:
				break;
			default:
				System.out.println("WprowadŸ liczbê od 1 do 4");
			}
		}

		// wejscie.close();

	}
}