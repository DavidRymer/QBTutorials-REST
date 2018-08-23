
import java.sql.*;



import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;

@Path("/web")
public class JDBC {
	
	 private final static String DB_URL = "jdbc:mysql://localhost:3306/qb_tutorials?autoReconnect=true&useSSL=false";
	 private final static String USER = "root";
	 private final static String PASS = "password";
	 private static Connection conn = null;
	 static Statement stmt = null;
	
	public static void dbConnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}

		//make a connection

		System.out.println("Connecting to database");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
//	
//	public static void disconnect() throws SQLException{
//		try { 
//			if (conn != null && !conn.isClosed()) {
//				conn.close();
//			}
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//	
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
//	@GET
//	@Path("/read/{fields}/{table}/{whereField}/{whereOperator}/{whereFieldValue}")
//	public static JSONArray read(@PathParam("fields") String[] fields, @PathParam("table") String table, @PathParam("whereField") String whereField, @PathParam("whereOperator") String whereOperator, @PathParam("whereFieldValue") String whereFieldValue) throws SQLException {
//		
//		dbConnect();
//		ResultSet rs = null;
//		JSONArray ja = null;
//
//		System.out.println("Creating statement...");
//		try {
//			stmt= conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String sql2 = "SELECT " + fields[0] +", ";
//
//		for (int i = 1; i < fields.length - 1; i++) {
//
//			sql2 += fields[i] +", ";
//
//		}
//		sql2 += fields[fields.length - 1];
//		if (whereField.equals("")==false) {
//
//			sql2 += " FROM " + table + " WHERE " + whereField + " "+ whereOperator + " " + whereFieldValue;
//		}
//		else {
//			sql2 += " FROM " +table;
//		}
//
//
//		if (fields.length == 1) {
//
//			sql2 = "SELECT " + fields[0] + " FROM " + table + " WHERE " + whereField + " "+ whereOperator + " " + whereFieldValue;
//		}
//
//		System.out.println(sql2);
//
//
//		try {
//			rs = stmt.executeQuery(sql2);
//			ja = Convertor.convertResultSetIntoJSON(rs);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			rs.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		disconnect();
//		return ja;
//
//	}
//	

	
	@GET
	@Path("/getQuestion/{questionLineID}")
	public String getQuestions(@PathParam("questionLineID") int questionLineID) throws SQLException {
		
		dbConnect();
		ResultSet rs = null;
		JSONArray ja = null;

		try {
			stmt= conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		String sql2 = "SELECT test_questions.question, test_questions.question_id, question_line.question_line_id, test_questions.answer\r\n" + 
				"FROM test_questions\r\n" + 
				"JOIN question_line\r\n" + 
				"ON test_questions.question_id = question_line.question_id\r\n" + 
				"WHERE question_line_id = "+ questionLineID + ";";



		try {
			rs = stmt.executeQuery(sql2);
			ja = Convertor.convertResultSetIntoJSON(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ja.toString();
		

	}

	
}
