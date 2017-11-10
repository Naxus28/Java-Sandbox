import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	   
	private String dbName;
	private String query;
	private String user;
	private String pass;
	private String dbURL;
	
	private Connection conn = null;
	private Statement stmt = null;
	
	public DataBase() {}
	
	public DataBase(String dbName, String user, String pass, String dbURL) {
		this.dbName = dbName;
		this.query =  "CREATE DATABASE " + dbName;
		this.user = user;
		this.pass = pass;
		this.dbURL = dbURL;
		
		try {
			createDB();

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	
	// DB helpers
	private synchronized void createDBConnection() throws SQLException {
		conn = DriverManager.getConnection(dbURL, user, pass);
		System.out.println("Connection created...");
	}
	
	private synchronized void createStmt() throws SQLException {
		if (conn != null) {
			stmt = conn.createStatement();
			System.out.println("Statement created...");
		} else {
			System.out.println("Please set a DB connection by invoking 'setDBConnection' before creating a statement");
		}
	}
	
	private synchronized void createDataBase() throws SQLException {
		if (stmt != null) {
			stmt.executeUpdate(query);
			System.out.println("DB created!");
		} else {
			System.out.println("Please create a SQL statement by invoking 'createStmt()' before creating the database");
		} 
	}
	
	// create DB
	
	private void createDB() throws SQLException {
		createDBConnection();
		createStmt();
		createDataBase();
	}
	
	
	// query
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}


	// dbName
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	// user
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	// pass
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	// dbURL
	public String getDbURL() {
		return dbURL;
	}
	
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	
}
