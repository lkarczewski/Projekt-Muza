import java.sql.*;

public class ZapiszDoBazy {
	
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Baza.db";
    
    private static Connection conn;
    private static Statement stmt;
	
    
	public static void main(String[] args) {

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
        String createPlyta="CREATE TABLE IF NOT EXISTS plyta(id VARCHAR(10), wykonawca VARCHAR(50), album VARCHAR(50), rok int(4), format VARCHAR(2))";
        try {
            stmt.execute(createPlyta);

        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
        }
       
        //dodaje przykladowe osoby
        String sql;
        try {
        	sql="BULK INSERT plyta FROM 'src\\Polskie Nagrania Muza.txt' WITH("
        			+ "FIELDTERMINATOR = ',', ROWTERMINATOR = '\n')"
        			+ "GO;";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu plyty");
            e.printStackTrace();
        }
       
        //wyswietlam zawartosc tabeli
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
                format = result.getString("format");
                System.out.println("id="+id+", wykonawca="+wykonawca+",album="+album+",rok="+rok+",format="+format);
            }
        } catch (SQLException e) {
            System.err.println("Blad przy wykonywaniu SELECT");
            e.printStackTrace();
        }
        
	}
}