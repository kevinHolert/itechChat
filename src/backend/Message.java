package backend;

public class Message {
	private User userFrom;
	private User userTo;
	private String message;
	private String timestamp;

	public Message(User userFrom, User userTo, String message, String timestamp) {
		super();
		this.userFrom = userFrom;
		this.userTo = userTo;
		this.message = message;
		this.timestamp = timestamp;
	}

	public User getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}
	public User getUserTo() {
		return userTo;
	}
	public void setUserTo(User userTo) {
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
