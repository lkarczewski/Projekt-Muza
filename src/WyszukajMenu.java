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
			System.out.println("2 - Wyszukaj wykonawc�");
			System.out.println("3 - Wyszukaj album");
			System.out.println("4 - Wr�c do g��wnego menu");
			System.out.println("------------------------------------");
			System.out.println("Wprowad� liczb� aby wybra� opcj�:");
			try {
				opcja = wejscie.nextInt();
			} catch (InputMismatchException e) {
				// wejscie.nextLine(); // przeczytaj wadliw� lini�
				opcja = 0;
			}
			wejscie.nextLine(); // przeczytanie ko�ca linii po cyfrze

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
				System.out.println("Wprowad� liczb� od 1 do 4");
			}
		}

		// wejscie.close();

	}
}