/**
 * this class holds state for db user
 * @author gferraz
 *
 */
public class DBUser {
	static String user;
	static String pass;
	
	public DBUser() {}
	
	public DBUser(String user, String pass) {
		DBUser.user = user;
		DBUser.pass = pass;
	}
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		DBUser.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		DBUser.pass = pass;
	}


}
