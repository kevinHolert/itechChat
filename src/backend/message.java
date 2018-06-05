package backend;

import java.sql.Timestamp;

public class message {
	private user userFrom;
	private user userTo;
	private String message;
	private String timestamp;
	
	
	public user getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(user userFrom) {
		this.userFrom = userFrom;
	}
	public user getUserTo() {
		return userTo;
	}
	public void setUserTo(user userTo) {
		this.userTo = userTo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
