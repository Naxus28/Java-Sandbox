package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataBase {
	// JDBC driver name and database URL--query string 'autoReconnect=true' will
	// attempt to auto reconnect to DB if connection is dead or stale;
	// 'useSSL=false' disables ssl
	// see query string options here:
	// https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-reference-configuration-properties.html
	private String defaultDBUrl = "jdbc:mysql://localhost?autoReconnect=true&useSSL=false";

	private String dbName;
	private String user;
	private String pass;
	private String dbURL;

	private Connection conn;
	private Statement stmt;

	/**
	 * default constructor
	 */
	public DataBase() {
	}

	/**
	 * overloaded constructor
	 * 
	 * @param dbName
	 * @param user
	 * @param pass
	 */
	public DataBase(String dbName, String user, String pass) {
		this.dbName = dbName;
		this.user = user;
		this.pass = pass;
	}

	/**
	 * create db connection
	 * 
	 * @param dbURL
	 * @throws SQLException
	 */
	protected synchronized void createDBConnection(String dbURL) throws SQLException {
		conn = DriverManager.getConnection(dbURL, user, pass);
		setConn(conn);
		
		System.out.println("Connection created...");
	}

	/**
	 * create db statement
	 * 
	 * @throws SQLException
	 */
	protected synchronized void createStmt() throws SQLException {
		stmt = conn.createStatement();
		System.out.println("Statement created...");
	}

	/**
	 * create database
	 * 
	 * @throws SQLException
	 */
	protected synchronized void createDataBase() throws SQLException {
		stmt.executeUpdate("CREATE DATABASE " + dbName);
	}

	/**
	 * execute update to create table
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public void createTable(String table, String columns) throws SQLException {
		String sql = "CREATE TABLE " + table + "(" + columns + ");";
		stmt.executeUpdate(sql);
		System.out.println("Table " + table + " created!");
	}

	abstract void insert(String table) throws SQLException;

	abstract void findOne() throws SQLException;

	abstract void delete() throws SQLException;

	/**
	 * printAll from DB
	 * 
	 * @param table
	 * @throws SQLException
	 */
	public void printAll(String table) throws SQLException {
		System.out.println("\nALL RESULTS: \n");
		ResultSet rs = stmt.executeQuery("select * from " + table);
		ResultSetMetaData metadata = rs.getMetaData();
		int columnCount = metadata.getColumnCount();

		// print columns--start at 1; 0 is out of range
		for (int i = 1; i <= columnCount; i++) {
			System.out.format("%-20s", metadata.getColumnName(i).toUpperCase());
		}

		System.out.println();

		// print rows
		while (rs.next()) {
			String row = "";

			for (int i = 1; i <= columnCount; i++) {
				row += String.format("%-20s", rs.getString(i));
			}

			System.out.println(row);
		}
	}

	/**
	 * execute methods to create database
	 * 
	 * @throws SQLException
	 */
	public void create() throws SQLException {
		createDBConnection(defaultDBUrl);
		createStmt();
		createDataBase();
		System.out.println("DB " + dbName + " created!");
	}

	/**
	 * connect to database
	 * 
	 * @throws SQLException
	 */
	public void connect() throws SQLException {
		dbURL = "jdbc:mysql://localhost/" + dbName + "?autoReconnect=true&useSSL=false";
		createDBConnection(dbURL);
		createStmt();
		System.out.println("Connected to DB " + dbName + "!");
	}

	/*** GETTERS AND SETTERS ***/

	// dbName
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	// user
	public String getDbUser() {
		return user;
	}

	public void setDbUser(String user) {
		this.user = user;
	}

	// pass
	public String getDbPass() {
		return pass;
	}

	public void setDbPass(String pass) {
		this.pass = pass;
	}

	// dbURL
	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	
	// defaultDBUrl
	public String getDefaultDBUrl() {
		return defaultDBUrl;
	}

	public void setDefaultDBUrl(String defaultDBUrl) {
		this.defaultDBUrl = defaultDBUrl;
	}
	
	// connection
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	// statement
	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

}
