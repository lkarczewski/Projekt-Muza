import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Filtrowanie {
	
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Baza.db";
    
    private static Connection conn;
    private static Statement stmt;
	
	void Filter() throws FileNotFoundException {
		
	    try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
	    
	    try {
            conn = DriverManager.getConnection(DB_URL);
            setStmt(conn.createStatement());
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem po³¹czenia");
            e.printStackTrace();
        }
		
	    Dodawanie dodaj = new Dodawanie();
    	File Plik = new File("src//Polskie Nagrania Muza.txt");
    	Scanner odczyt = new Scanner(Plik);
    	
    	StringTokenizer token;
        String[] tab = new String[50];
        int i;
    	
    	while(odczyt.hasNextLine()){
    		i=0;
    		token = new StringTokenizer(odczyt.nextLine(),";");
    		while(token.hasMoreElements()){
    			tab[i]=token.nextToken();
    			i++;
    		}
    		i=0;
    		dodaj.Add(Integer.parseInt(tab[0]),tab[1],tab[2],Integer.parseInt(tab[3]));
    	}
    	odczyt.close();   
      	System.out.println("Dodano odfiltrowane dane z pliku");
    }

	public static Statement getStmt() {
		return stmt;
	}

	public static void setStmt(Statement stmt) {
		Filtrowanie.stmt = stmt;
	}

}