/*Needed libraries:
 * 
 *----------- apache-commons-codec-1.9
 *----------- mysql-connector-java-8.0.11
 * see dependencies folder
 *
 * */

package backend;

import java.sql.*;
import java.sql.Connection;



public class dbConnect {
	private String JDBC_DRIVER;  
    private String DB_URL;
    //Database credentials
    private String USER;
    private String PASS;
    private Connection conn;

    public dbConnect(){
        JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        DB_URL = "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC";
        USER = "root";
        PASS = "";
        conn = null;
    }
    public void openConnection(){
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);         
            //Open a connection
            System.out.print("Connecting to a selected database... ");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Success!");     
        }catch(Exception e){
            //Handle errors for JDBC
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try{
            if(conn!=null)
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
        System.out.println("Connection closed");
    }
    
    public void insertUser(User user){
    	
    	String query = new String();
    	this.openConnection();
    	
    	try{
    		query = " insert into user (username, password, salt)"
    		        + " values (?, ?, ?)";
    		
    		// create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, user.getUsername());
		      preparedStmt.setString (2, user.getPw());
		      preparedStmt.setString (3, user.getSalt());

		      // execute the preparedstatement
		      preparedStmt.execute();
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				this.closeConnection();
			}
		}
    }
    
    public void insertMessage(int userFrom, int userTo, String message){
    	String query = new String();
    	this.openConnection();
    	Timestamp dt = new Timestamp(1111);
    	dt = new Timestamp(dt.getTime())	;
    	
    	try{
    		query = " insert into message (message, User_idUser_From, User_idUser_To, timestamp)"
    		        + " values (?, ?, ?, ?)";
    		
    		// create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, message);
		      preparedStmt.setInt (2, userFrom);
		      preparedStmt.setInt (3, userTo);
		      preparedStmt.setTimestamp(4, dt);
		      
		      
		      preparedStmt.execute();
		      
		      
    	}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				this.closeConnection();
			}
		}
    }
    
    public String getPW(String username){
    	String result = new String();
    	String query = new String();
    	
    	result=null;
    	
    	this.openConnection();
    	try{
    		query = "SELECT password from user Where user.username='"+username+"'";
    		
    		Statement s= conn.createStatement();
    		s.execute(query);
    		
    		ResultSet r = s.getResultSet();
    		
    		if(r!=null){
    			while(r.next()){
    				result= r.getString("Password");
    			}
    		}
    		
    		
		      
    	}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				this.closeConnection();
			}
			return result;
		}
    }
    
    public boolean confirmUsername(String username){
    	boolean result = false;
    	String un = "null";
    	String query = new String();
    	
    	this.openConnection();
    	try{
    		query = "SELECT username from user Where user.username='"+username+"'";
    		
    		Statement s= conn.createStatement();
    		s.execute(query);
    		
    		ResultSet r = s.getResultSet();
    		
    		if(r!=null){
    			while(r.next()){
    				un= r.getString("Username");
    				result = true;
    			}
    		}
    		System.out.println("ist kevin da? "+result);
    		
		      
    	}catch(SQLException e){
			e.printStackTrace();
		}finally{
			return result;
		}
    	
    }
    
    public User getUser(String username){
    	User result = new User();
    	String query = new String();
    	
    	if(confirmUsername(username)){
    		this.openConnection();
    		try{
    			query = "SELECT * from user Where user.username='"+username+"'";
        		
        		Statement s= conn.createStatement();
        		s.execute(query);
        		
        		ResultSet r = s.getResultSet();
        		if(r!=null){
        			while(r.next()){
        				result.setUserid(r.getInt("iduser"));
        				result.setUsername(r.getString("username"));
        				result.setPw(r.getString("password"));
        				result.setSalt(r.getString("salt"));
        			}
        		}
    		}catch(SQLException e){
    			e.printStackTrace();
    		}
    	}
		return result;
    }
    
    public Chat getChat(int userFrom, int userTo){
    	Chat result = new Chat();
    	String query = new String();
    	
    	this.openConnection();
		try{
			query = "SELECT * FROM message Where message.user_iduser_from='"+userFrom+"' AND message.user_userid_to='"+userTo+"'";
    		
    		Statement s= conn.createStatement();
    		s.execute(query);
    		
    		ResultSet r = s.getResultSet();
    		if(r!=null){
    			while(r.next()){
    				/*result.setUserid(r.getInt("iduser"));
    				result.setUsername(r.getString("username"));
    				result.setPw(r.getString("password"));
    				result.setSalt(r.getString("salt"));*/
    			}
    		}
		}catch(SQLException e){
			e.printStackTrace();
		}
    	return result;
    }
    
}
	

