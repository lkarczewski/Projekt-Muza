import java.util.Scanner;

public class ZestawieniaMenu {
	
	void JuxMenu(){
		
		WykonawcaIlosc op6a = new WykonawcaIlosc();
		//RokIlosc op6b = new RokIlosc();
		
		Scanner wejscie = new Scanner(System.in);
		int opcja = 0;
		
		while(opcja!=3) {
		System.out.println("-----------ZESTAWIENIA----------------------------------------------------------");
		System.out.println("1 - Iloœæ p³yt wydanych przez poszczególnych wykonawców w latach 1956-1990");
		System.out.println("2 - Iloœæ p³yt wydanych w latach 1956-1990");
		System.out.println("3 - Wróæ do menu g³ównego");
		System.out.println("--------------------------------------------------------------------------------");
		opcja=wejscie.nextInt();
		
		switch(opcja) {
		case 1:
			op6a.ArtistCount();
			break;
		case 2:
			System.out.println("Wybra³eœ opcje 2");
			break;
		case 3:
			return;
		default:System.out.println("WprowadŸ poprawn¹ liczbê");
		}
	}
	wejscie.close();
}
}