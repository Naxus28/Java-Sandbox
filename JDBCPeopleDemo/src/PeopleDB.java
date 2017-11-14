import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * this class holds state for people db it inherits from {@link}DataBase
 * 
 * @author gferraz
 */
public class PeopleDB extends DataBase {
	private People person;
	private String dbName;
	private String user;
	private String pass;
	private String dbURL;
	private Connection conn = getConn();

	// table
	static final String table = "PERSON";
	static final String columns = "person_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
			+ "fist_name VARCHAR(30) NOT NULL, " + "last_name VARCHAR(30) NOT NULL, " + "age INT UNSIGNED NOT NULL, "
			+ "ssn BIGINT UNSIGNED UNIQUE NOT NULL, " + "credit_card BIGINT UNSIGNED";

	static private String[] personColumns = { "first_name", "last_name", "age", "ssn", "credit_card" };

	public PeopleDB() {}

	public PeopleDB(People person, String dbName, String user, String pass) {
		super(dbName, user, pass);
		this.person = person;
	}

	public void createTable() {
		try {
			createTable(table, columns);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	void insert(String table) throws SQLException {
		// the mysql insert statement
		StringBuilder columnsQuery = new StringBuilder("INSERT INTO " + table + "(person_id, ");
		StringBuilder valuesQuery = new StringBuilder("values(?, ");
		StringBuilder sql;
		String[] columns = getTableColumns(table);

		for (int i = 0; i <= columns.length - 1; i++) {
			if (i == columns.length - 1) {
				columnsQuery.append(columns[i] + ") ");
				valuesQuery.append("?) ");
			} else {
				columnsQuery.append(columns[i] + ", ");
				valuesQuery.append("?, ");
			}
		}

		sql = columnsQuery.append(valuesQuery);

		System.out.println("sql: " + sql);

		if (table.toLowerCase().equals("person")) {
			insertIntoPersonTable(sql);
		}

	}

	private void insertIntoPersonTable(StringBuilder sql) throws SQLException {
		PreparedStatement preparedStmt = super.getConn().prepareStatement(sql.toString());
		preparedStmt.setNull(1, java.sql.Types.NULL);
		preparedStmt.setString(2, person.getFirstName());
		preparedStmt.setString(3, person.getLastName());
		preparedStmt.setInt(4, person.getAge());
		preparedStmt.setLong(5, person.getSsn());
		preparedStmt.setLong(6, person.getCreditCard());

		// execute statement
		preparedStmt.execute();
		System.out.println("Inserted into PEOPLE.PERSON");
	}

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

	@Override
	void findOne() throws SQLException {

	}

	@Override
	void delete() throws SQLException {

	}

	public People getPerson() {
		return person;
	}

	public void setPerson(People person) {
		this.person = person;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
