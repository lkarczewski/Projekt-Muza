import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RokIlosc {
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Baza.db";
    
    private static Connection conn;
    private static Statement stmt;;
    
	void YearCount(){
		
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
    	
	 	   try {
	 		   	conn = DriverManager.getConnection(DB_URL);
	            ResultSet result = stmt.executeQuery("SELECT wykonawca COUNT(album) AS LiczbaPlyt FROM plyta GROUP BY wykonawca ORDER BY LiczbaPlyt DESC;");
	            //int id;
	            String wykonawca;
	            int LiczbaPlyt;
	            //String album;
	            //int rok;
	            while(result.next()) {
	                //id = result.getInt("id");
	                wykonawca = result.getString("wykonawca");
	                LiczbaPlyt = result.getInt("LiczbaPlyt");
	                //album = result.getString("album");
	                //rok = result.getInt("rok");
	                System.out.println("wykonawca="+wykonawca+",LiczbaPlyt="+LiczbaPlyt++);
	            }
	            System.out.println("");
	        }
	 	   
	 	   catch (SQLException e) {
	            System.err.println("Blad przy wykonywaniu SELECT");
	            e.printStackTrace();
	        }

}
}

