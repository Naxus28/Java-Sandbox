//STEP 1. Import required packages
import java.sql.*;

public class JDBCDemo {
   // JDBC driver name and database URL
   static final String dbURL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String user = "root";
   static final String pass = "UFPhD2012";
   
   // Database info
   static String dbName = "STORE";
   
   public static void main(String[] args) {
	   // creates db on instantiation
	   DataBase db = new DataBase(dbName, user, pass, dbURL);

	   
   }
}