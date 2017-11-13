import java.sql.SQLException;
import java.util.List;

/**
 * this class holds state for people db
 * it inherits from {@link}DataBase
 * @author gferraz
 */
public class PeopleDB extends DataBase {
	People person;
	String dbName;
	String user; 
	String pass;
	String dbURL;
	
   //  table
   static final String table = "PERSON";
   static final String columns = "person_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
   		+ "fist_name VARCHAR(30) NOT NULL, "
   		+ "last_name VARCHAR(30) NOT NULL, "
   		+ "age INT UNSIGNED NOT NULL, "
   		+ "ssn BIGINT UNSIGNED UNIQUE NOT NULL, "
   		+ "credit_card BIGINT UNSIGNED";
   static private String[] personColumns = {"first_name", "last_name", "age", "ssn", "credit_card"};
	
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
		 StringBuilder columnsQuery  =  new StringBuilder("INSERT INTO " + table + "(");
		 StringBuilder valuesQuery = new StringBuilder("values(");
		 StringBuilder sql;
		 String[] columns = getTableColumns(table);
		  
		 for(int i=0; i <= columns.length - 1; i++) {
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
	}
	
	
	private String[] getTableColumns(String table) {
		String[] columns;
		
		switch(table.toLowerCase()) {
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
	


}
