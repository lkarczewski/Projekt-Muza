import java.sql.*;

public class StworzBaze {
	
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Baza.db";
    
    private static Connection conn;
    private static Statement stmt;
    
    void Create(){
    	
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
       
        //tworze tabele
        String createPlyta="CREATE TABLE IF NOT EXISTS plyta(id VARCHAR(10), wykonawca VARCHAR(50), album VARCHAR(50), rok VARCHAR(4));";
        try {
            stmt.execute(createPlyta);

        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
        }
        
        //dodaje przykladowe osoby
        String sql;
        try {
        	sql="INSERT INTO plyta(id, wykonawca, album, rok) VALUES('0001','Witold Rowicki','Ludwik van Beethoven VII Symfonia','1956');";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu plyty");
            e.printStackTrace();
        }
        
        System.out.println("Utworzono baz� danych");
    }
}
