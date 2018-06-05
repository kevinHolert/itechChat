package backend;

import java.util.ArrayList;

public class chat {
	private user user1;
	private user user2;
	private ArrayList<message> messages;
	
	public user getUser1() {
		return user1;
	}
	public void setUser1(user user1) {
		this.user1 = user1;
	}
	public user getUser2() {
		return user2;
	}
	public void setUser2(user user2) {
		this.user2 = user2;
	}
	public ArrayList<message> getMessages() {
		return messages;
	}
	public void setMessages(ArrayList<message> messages) {
		this.messages = messages;
	}
	
	public void setMessage(user userFrom, user userTo, String message, String timestamp){
		
	}
}
