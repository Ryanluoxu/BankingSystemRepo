package bean;

public class User {
	
	private int userID;
	private String password;
	private String userType;
	private int passwordCounter;
	private boolean isLocked;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getPasswordCounter() {
		return passwordCounter;
	}
	public void setPasswordCounter(int passwordCounter) {
		this.passwordCounter = passwordCounter;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

}
