package backend;

public class user {
	private int userid = 0;
	private String username;
	private String pw;
	private String salt;
	
	
	public user(){
		
	}
	
	public String hashpassword(String password){
		generateSalt();
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(password+this.salt);
	}
	
	public String hashpassword(String password, String salt){
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(password+salt);
	}
	
	public user(String username,String pass){
		this.username = username;
		this.pw = this.hashpassword(pass); 
	}
	
	public void generateSalt(){
		int count = 8;
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		this.salt = builder.toString();
		
		
	}
	
	public boolean checkPw(String username,String pw){
		boolean result = false;
		String pass = new String();
		dbConnect db = new dbConnect();
		user u1 = new user();
		
		u1 = db.getUser("username");
		String hashedPW = u1.hashpassword(pw,u1.salt);
		if(u1.getUsername()==username && hashedPW == u1.getPw()){
			result=true;
		}
				
		return result;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
	
}
