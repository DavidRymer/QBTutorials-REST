
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
//	@POST
//	@Path("/addUser/{firstName}/{lastName}/{email}/{assignedTutor}")
//	public  void createUser(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName, @PathParam("email") String email, @PathParam("assignedTutor") int assignedTutor) throws SQLException {
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
//		String sql= "INSERT INTO user_details (first_name, last_name, email, assigned_tutor) VALUES (" +"'" + firstName +"'"+", " +"'"+ lastName +"'"+ ", " +"'"+ email+"' , " +assignedTutor+ ")";
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
	@Path("/login/{username}/{hashword}")
	public String getQuestions(@PathParam("username") String username, @PathParam("hashword") String hashword) throws SQLException {
		
		String[] fields = {"username", "hashword"};
		
		String user = JDBC.read(fields, "user_details", "username", "=", "'" + username + "'").toString();
		user = user.replace("[", "");
		user = user.replace("]", "");
		
		System.out.println(user);
		return user;
	}
	
	
	

	
	
		
	

	
}
