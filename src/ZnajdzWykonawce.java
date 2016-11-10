import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZnajdzWykonawce {
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Baza.db";
    
    private static Connection conn;
    private static Statement stmt;
    
    void FindArtist(){
    	//dodaje klase JDBC
	    try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
	    
        //nawiazuje polaczenie z baza danych
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem połączenia");
            e.printStackTrace();
        }
        
        Scanner input = new Scanner(System.in);
        String artist = input.nextLine();
		String findArtist;
		try{
    		findArtist="SELECT * FROM plyta WHERE wykonawca='"+artist+"';";
    		stmt.execute(findArtist);
    	} catch (SQLException e){
    		System.err.println("Blad przy znajdywaniu wykonawcy");
            e.printStackTrace();
    	}
		input.close();
		
    }

}
