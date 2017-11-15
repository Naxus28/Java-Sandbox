package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * this class holds state for people db; it inherits from {@link}DataBase
 * 
 * @author gferraz
 */
public class PeopleDB extends DataBase {
	private People person;
	private String dbName;
	private String dbUser;
	private String dbPass;
	private String dbURL;
	final static String[] personColumns = { "first_name", "last_name", "age", "ssn", "credit_card" };
	
	Security security = new Security();

	/**
	 * default constructor
	 */
	public PeopleDB() {
	}

	/**
	 * overloaded constructor
	 * 
	 * @param dbName
	 * @param dbUser
	 * @param dbPass
	 */
	public PeopleDB(String dbName, String dbUser, String dbPass) {
		this(null, dbName, dbUser, dbPass);
	}

	/**
	 * overloaded constructor
	 * 
	 * @param person
	 * @param dbName
	 * @param user
	 * @param pass
	 */
	public PeopleDB(People person, String dbName, String dbUser, String dbPass) {
		super(dbName, dbUser, dbPass);
		System.out.println("dbName: " + dbName);
		this.person = person;
	}

	/**
	 * create table helper
	 */
	public void createTable() {
		// table
		final String table = "PERSON";

		// create table query
		final String columns = "person_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
				+ "first_name VARCHAR(30) NOT NULL, " + "last_name VARCHAR(30) NOT NULL, "
				+ "age INT UNSIGNED NOT NULL, " + "ssn VARCHAR(100) UNIQUE NOT NULL, "
				+ "credit_card VARCHAR(100)";

		try {
			createTable(table, columns);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * overrides parent abstract method invokes insert methods for specific tables
	 * passed from parameter
	 * 
	 * @param the
	 *            target table
	 */
	@Override
	public void insert(String table) throws SQLException {
		// the mysql insert statement
		StringBuilder columnsQuery = new StringBuilder("INSERT INTO " + table + "(");
		StringBuilder valuesQuery = new StringBuilder("values(?, ");
		StringBuilder sql;
		String[] columns = getTableColumns(table);

		// if table is "person", append the first column name
		// this control structure allows to append the auto_increment field
		// for different tables--perhaps not the best design
		if (table.toLowerCase().equals("person")) {
			columnsQuery.append("person_id, ");
		}

		// generate columns and values for query
		for (int i = 0; i <= columns.length - 1; i++) {
			if (i == columns.length - 1) {
				columnsQuery.append(columns[i] + ") ");
				valuesQuery.append("?) ");
			} else {
				columnsQuery.append(columns[i] + ", ");
				valuesQuery.append("?, ");
			}
		}

		// create full query string
		sql = columnsQuery.append(valuesQuery);

		// control structure that allows insertion of data into different tables
		if (table.toLowerCase().equals("person")) {
			insertIntoPersonTable(sql);
		}

	}

	/**
	 * insert person into person table
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	private void insertIntoPersonTable(StringBuilder sql) throws SQLException {
		
		// convert long to bytes
		byte[] ssnBytes = Long.toString(person.getSsn()).getBytes();
		byte[] ccBytes = Long.toString(person.getCreditCard()).getBytes();
		
		// create hashes
		String ssnHash = security.getHash(ssnBytes, "SHA-256");
		String ccHash = security.getHash(ccBytes, "SHA-256");
		
		// create prepared statements
		PreparedStatement preparedStmt = getConn().prepareStatement(sql.toString());
		preparedStmt.setNull(1, java.sql.Types.NULL);
		preparedStmt.setString(2, person.getFirstName());
		preparedStmt.setString(3, person.getLastName());
		preparedStmt.setInt(4, person.getAge());
		preparedStmt.setString(5, ssnHash);
		preparedStmt.setString(6, ccHash);

		// execute statement
		preparedStmt.execute();
		System.out.println("Inserted new record into PERSON");
	}

	@Override
	public void findOne(String ssn) throws SQLException {
		String sql =  String.format("SELECT * FROM PERSON WHERE `ssn`='%s'", ssn.toString());

		String row = null;

		ResultSet rs = getStmt().executeQuery(sql);

		while (rs.next()) {
			row = rs.getString("first_name") + " " + rs.getString("last_name") + ", " + rs.getString("age") + ", ssn: "
					+ rs.getString("ssn") + ", credit card #: " + rs.getString("credit_card");
		}

		System.out.println("Found record " + row + " from database " + super.getDbName());
	}

	@Override
	public void deleteOne(String ssn) throws SQLException {
		String sql =  String.format("DELETE FROM PERSON WHERE `ssn`='%s'", ssn.toString());

		getStmt().executeUpdate(sql);
		System.out.println("Deleted record from database " + super.getDbName());
	}

	/**
	 * get table columns
	 * 
	 * @param table
	 *            the table whose columns we want to get
	 * @return
	 */
	private String[] getTableColumns(String table) {
		String[] columns;

		switch (table.toLowerCase()) {
		case "person":
			columns = personColumns;
			break;
		default:
			columns = personColumns;
			break;
		}

		return columns;
	}

	// person
	public People getPerson() {
		return person;
	}

	public void setPerson(People person) {
		this.person = person;
	}

	// db name
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	// db user
	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String user) {
		this.dbUser = user;
	}

	// db password
	public String getDbPass() {
		return dbPass;
	}

	public void setDbPass(String pass) {
		this.dbPass = pass;
	}

	// db url
	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

}
