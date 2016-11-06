import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dodawanie {
	
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Baza.db";
    
    private static Connection conn;
    private static Statement stmt;
    
    int id = 0;
	String wykonawca = null;
	String album = null;
	int rok = 0;
    
	void Add(int id, String wykonawca, String album, int rok){
		
	    try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
	    
	    try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem po³¹czenia");
            e.printStackTrace();
        }
		
    	String sql;
    	try{
    		sql="INSERT INTO plyta(id,wykonawca,album,rok) VALUES ('"+id+"','"+wykonawca+"','"+album+"','"+rok+"');";
    		stmt.execute(sql);
    	} catch (SQLException e){
    		System.err.println("Blad przy dodawaniu rekordu");
            e.printStackTrace();
    	}
    	System.out.println("Dodano odfiltrowane dane z pliku");
    }

}
