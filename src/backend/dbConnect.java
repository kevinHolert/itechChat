/*Needed libraries:
 * 
 *----------- apache-commons-codec-1.4
 *----------- mysql-connector-java-8.0.11
 *
 * */

package backend;

import java.sql.*;

import com.mysql.jdbc.*;

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
    
    public void createUser(String name, String pw, String salt){
    	
    	String query = new String();
    	this.openConnection();
    	
    	try{
    		query = " insert into user (username, password, salt)"
    		        + " values (?, ?, ?)";
    		
    		// create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, name);
		      preparedStmt.setString (2, pw);
		      preparedStmt.setString (3, salt);

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
    
    public void createMessage(int userFrom, int userTo, String message){
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
    	
    	this.openConnection();
    	try{
    		query = "SELECT * from mydb.user";
    		
    		// create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		     
		      
		      
		      preparedStmt.execute();
		      
		      
    	}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				this.closeConnection();
			}
		}
    	
    	
    	return result;
    }
}
	

