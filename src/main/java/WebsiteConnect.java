
import java.sql.*;



import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;

@Path("/web")
public class WebsiteConnect {
	
	
	
//	
//	
//	@POST
//	@Produces("Application/json")
//	@Path("/addResult/{userID}/{score}/{testID}")
//	public void createTestResult(@PathParam("userID") int userID, @PathParam("score") int score, @PathParam("testID") int testID) throws SQLException {
//        dbConnect();
//		System.out.println("Inserting records into the table...");
//
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String sql= "INSERT INTO test_results (user_id, score, test_id) VALUES (" + userID +", " + score + ", " + testID + ")";
//		try {
//			stmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Inserted records into the table...");
//		System.out.println(sql);
//		disconnect();
//
//	}
//	

//	
//	
//	
//	@POST
//	@Path("/addTutorSession/{tutorID}/{userID}/{length}/{dateTime}")
//	public  void createTutorSession(@PathParam("tutorID") int tutorID, @PathParam("userID") int userID, @PathParam("length") int length, @PathParam("dateTime") String dateTime) throws SQLException {
//		
//        dbConnect();
//		System.out.println("Inserting records into the table...");
//
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String sql= "INSERT INTO tutor_session (tutor_id, user_id, length, date_time) VALUES (" + tutorID +", "+ userID +", " + length + ", " +"'"+ dateTime +"'"+ ")";
//		try {
//			stmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Inserted records into the table...");
//		System.out.println(sql);
//		disconnect();
//	}
//
//	
	
	
	

	
	@GET
	@Path("/getQuestionLine/{topic}/{difficulty}/{level}")
	public String getQuestions(@PathParam("topic") String topic, @PathParam("difficulty") String difficulty, @PathParam("level") String level) throws SQLException {
		String questions = JDBC.getQuestions(topic, difficulty, level);
		
		System.out.println(questions);
		return questions;
	}
	
	@GET
	@Path("/login/{username}")
	public String login(@PathParam("username") String username) throws SQLException {
		
		String[] fields = {"username", "hashword", "first_name"};
		
		String user = JDBC.read(fields, "user_details", "username", "=", "'" + username + "'").toString();
		user = user.replace("[", "");
		user = user.replace("]", "");
		
		System.out.println(user);
		return user;
	}
	
	@GET
	@Path("/getEmail/{email}")
	public String getEmail(@PathParam("email") String email) throws SQLException {
		
		String[] fields = {"email"};
		
		String user = JDBC.read(fields, "user_details", "email", "=", "'" + email + "'").toString();
		user = user.replace("[", "");
		user = user.replace("]", "");
		
		System.out.println(user);
		return user;
	}
	
	
	
	@POST
	@Path("/register/{username}/{password}/{firstName}/{lastName}/{email}")
	public void createUser(@PathParam("username") String username, @PathParam("password") String password, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName, @PathParam("email") String email) throws SQLException {
        
		JDBC.createUser(username, password, firstName, lastName, email);

	}

	
	
		
	

	
}
