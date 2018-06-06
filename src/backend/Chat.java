package backend;

import java.util.ArrayList;

public class Chat {
	private User user1;
	private User user2;
	private ArrayList<Message> allMessages = new ArrayList<>();

	public Chat getwholeChat(User u1, User u2){
		dbConnect db = new dbConnect();
		return db.getAllMessages(u1, u2);
	}

	public ArrayList<Message> getAllMessages() {
		return allMessages;
	}

	public void setAllMessages(ArrayList<Message> allMessages) {
		this.allMessages = allMessages;
	}

	public void addToAll(Message message){
		this.allMessages.add(message);
	}


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


	public void setSentMessages(ArrayList<Message> sentMessages) {
		sentMessages = sentMessages;
	}


	public void setReceivedMessages(ArrayList<Message> receivedMessages) {
		receivedMessages = receivedMessages;
	}
}