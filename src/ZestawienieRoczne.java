import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZestawienieRoczne {
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Baza.db";
    
    private static Connection conn;
    private static Statement stmt;
    
    void DisplayYear(){
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
        String year = input.nextLine();
		String findYear;
		try{
    		findYear="SELECT * FROM plyta WHERE rok='"+year+"';";
    		stmt.execute(findYear);
    	} catch (SQLException e){
    		System.err.println("Blad przy znajdywaniu roku");
            e.printStackTrace();
    	}
		input.close();
		
    }

}
