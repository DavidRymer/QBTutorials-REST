import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.PathParam;

import org.json.JSONArray;

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

	public static void disconnect() throws SQLException{
		try { 
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static JSONArray read(String[] fields, String table, String whereField, String whereOperator, String whereFieldValue) throws SQLException {

		dbConnect();
		JSONArray ja = null;

		System.out.println("Creating statement...");
		try {
			stmt= conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql2 = "SELECT " + fields[0] +", ";

		for (int i = 1; i < fields.length - 1; i++) {

			sql2 += fields[i] +", ";

		}
		sql2 += fields[fields.length - 1];
		if (whereField.equals("")==false) {

			sql2 += " FROM " + table + " WHERE " + whereField + " "+ whereOperator + " " + whereFieldValue;
		}
		else {
			sql2 += " FROM " +table;
		}


		if (fields.length == 1) {

			sql2 = "SELECT " + fields[0] + " FROM " + table + " WHERE " + whereField + " "+ whereOperator + " " + whereFieldValue;
		}

		System.out.println(sql2);


		try (ResultSet rs = stmt.executeQuery(sql2);) {
			ja = Convertor.convertResultSetIntoJSON(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ja;

	}
	
	public static String getQuestions(String topic, String difficulty, String level) throws SQLException {

		dbConnect();
		ResultSet rs = null;
		JSONArray ja = null;

		try {
			stmt= conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String[] fields = {"question_line_id"};
		String questionLine = read(fields, "test", "topic = " + "'" + topic +
				"' AND " + "difficulty = " + "'" + difficulty+"' AND " +
				"level = " + "'" + level+"';", "", "").toString();
		
		int questionLineID = OnlineTest.firstInt(questionLine);
		


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
	public static void createUser(String username, String password, String firstName, String lastName, String email) throws SQLException {
        JDBC.dbConnect();
		System.out.println("Inserting records into the table...");
		int hashword = password.hashCode();

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql= "INSERT INTO user_details (username, hashword, first_name, last_name, email) VALUES ("+"'" + username +"' , "+"'" + hashword +"' , " +"'" + firstName +"'"+", " +"'"+ lastName +"'"+ ", " +"'"+ email+"'" +")";
		System.out.println(sql);
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");
		System.out.println(sql);
		JDBC.disconnect();
	}


}
