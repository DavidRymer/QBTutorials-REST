
import java.sql.*;



import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;

@Path("/web")
public class WebsiteConnect {
	
	
	
	
	
	@POST
	@Produces("Application/json")
	@Path("/addResult/{userID}/{score}/{testID}")
	public void addResult(@PathParam("userID") int userId, @PathParam("score") int score, @PathParam("testID") int testId) throws SQLException {
		
		JDBC.createTestResult(userId, score, testId);
	}
	
	@POST
	@Produces("Application/json")
	@Path("/addSession/{tutorId}/{userId}/{date}/{hour}")
	public void addSession(@PathParam("tutorId") String tutorId, @PathParam("userId") int userId, @PathParam("date") String date, @PathParam("hour") int hour) throws SQLException {
		
		JDBC.createTutorSession(tutorId, userId, date, hour);
	}
	

	
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
		
		String[] fields = {"username", "hashword", "first_name", "user_id"};
		
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
	
	@GET
	@Path("/getTimes/{date}")
	public String getTimes(@PathParam("date") String date) throws SQLException {
		
		String[] fields = {"hour"};
		
		String user = JDBC.read(fields, "tutor_session", "date", "=", "'" + date + "'").toString();
	
		
		System.out.println(user);
		return user;
	}

	
	
		
	

	
}
