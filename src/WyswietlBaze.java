import java.sql.*;

public class WyswietlBaze {
	
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Baza.db";

    private static Statement stmt;
    
    void Show(){
    	
    	   try {
               ResultSet result = stmt.executeQuery("SELECT * FROM plyta");
               int id;
               String wykonawca;
               String album;
               String rok;
               String format;
               while(result.next()) {
                   id = result.getInt("id");
                   wykonawca = result.getString("wykonawca");
                   album = result.getString("album");
                   rok = result.getString("rok");
                   System.out.println("id="+id+", wykonawca="+wykonawca+",album="+album+",rok="+rok+);
               }
           }
    	   
    	   catch (SQLException e) {
               System.err.println("Blad przy wykonywaniu SELECT");
               e.printStackTrace();
           }

    }
}
