import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZnajdzAlbum {
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Baza.db";
    
    private static Connection conn;
    private static Statement stmt;
    
    void FindAlbum(){
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
            System.err.println("Problem z otwarciem po³¹czenia");
            e.printStackTrace();
        }
        
        Scanner input = new Scanner(System.in);
        String record = input.nextLine();
		String findAlbum;
		try{
    		findAlbum="SELECT * FROM plyta WHERE album='"+record+"';";
    		stmt.execute(findAlbum);
    	} catch (SQLException e){
    		System.err.println("Blad przy znajdywaniu wykonawcy");
            e.printStackTrace();
    	}
		input.close();
		
    }

}
