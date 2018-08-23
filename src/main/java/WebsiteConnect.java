
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
	@Path("/getQuestion/{questionLineID}")
	public String getQuestions(@PathParam("questionLineID") int questionLineID) throws SQLException {
		
		return JDBC.getQuestions(questionLineID);
	}
	
	@GET
	@Path("/getQuestionLine/{topic}/{difficulty}/{level}")
	public String getQuestionLineId(@PathParam("topic") String topic, @PathParam("difficulty") String difficulty, @PathParam("level") String level) throws SQLException {
		
		String[] fields = {"question_line_id"};
		
		String questionLine = JDBC.read(fields, "test", "topic = " + "'" + topic + "' AND " + "difficulty = " + "'" + difficulty+"' AND " + "level = " + "'" + level+"';", "", "").toString();
//		int questionLineId = OnlineTest.firstInt(questionLine);
		
		questionLine = questionLine.replace("[", "");
		questionLine = questionLine.replace("]", "");
		System.out.println(questionLine);
		return questionLine;
		
		
	}
	
	
		
	

	
}
