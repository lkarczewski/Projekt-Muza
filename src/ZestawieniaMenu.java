import java.util.Scanner;

public class ZestawieniaMenu {
	
	void JuxMenu(){
		
		WykonawcaIlosc op6a = new WykonawcaIlosc();
		//RokIlosc op6b = new RokIlosc();
		
		Scanner wejscie = new Scanner(System.in);
		int opcja = 0;
		
		while(opcja!=3) {
		System.out.println("-----------ZESTAWIENIA----------------------------------------------------------");
		System.out.println("1 - Ilo�� p�yt wydanych przez poszczeg�lnych wykonawc�w w latach 1956-1990");
		System.out.println("2 - Ilo�� p�yt wydanych w latach 1956-1990");
		System.out.println("3 - Wr�� do menu g��wnego");
		System.out.println("--------------------------------------------------------------------------------");
		opcja=wejscie.nextInt();
		
		switch(opcja) {
		case 1:
			op6a.ArtistCount();
			break;
		case 2:
			System.out.println("Wybra�e� opcje 2");
			break;
		case 3:
			return;
		default:System.out.println("Wprowad� poprawn� liczb�");
		}
	}
	wejscie.close();
}
}