/**
 * this class holds state for db user
 * @author gferraz
 *
 */
public class DBUser {
	private String user;
	private String pass;
	
	public DBUser() {}
	
	public DBUser(String user, String pass) {
		this.user = user;
		this.pass = pass;
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


}
