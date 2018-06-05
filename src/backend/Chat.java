package backend;

import java.util.ArrayList;

public class Chat {
	private User user1;
	private User user2;
	private ArrayList<Message> messages;
	
	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	public User getUser2() {
		return user2;
	}
	public void setUser2(User user2) {
		this.user2 = user2;
	}
	public ArrayList<Message> getMessages() {
		return messages;
	}
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	
	public void setMessage(User userFrom, User userTo, String message, String timestamp){
		
	}
}
