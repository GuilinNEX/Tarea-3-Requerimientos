package domain;

public class SignIn 
{
	private String username;
	private String password;
	
	
	public SignIn (String pUsername, String pPassword)
	{
		this.username = pUsername;
		this.password = pPassword;
	}
	
	//GETTS & SETTERS
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
