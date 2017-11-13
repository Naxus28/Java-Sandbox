import java.sql.SQLException;

public class JDBCDemo {

   //  Database credentials
   static final String user = "root";
   static final String pass = "UFPhD2012";
   
   // Database name 
   static String dbName = "PEOPLE";
   
   public static void main(String[] args) {
	   DataBase db = new DataBase(dbName, user, pass);
	   
	   try {
		   db.connect();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	
	
	   try {
		   db.printAll("person");
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
 
  }
}