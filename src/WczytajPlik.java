import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WczytajPlik {
	public static void main(String[] args) throws FileNotFoundException{
		
		File f = new File("Plik.txt");
		Scanner in = new Scanner(f);
		
		int i;
		int fileLength=10;
	
		for(i=0;i<fileLength;i++){
			String rekord = in.nextLine();
			System.out.println(rekord);
		}
		
		in.close();
	}
}