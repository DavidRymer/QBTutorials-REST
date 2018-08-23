

import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;

public class OnlineTest {
	

	public static int firstInt(String string) { 

		int i = 0;
		while (i < string.length() && !Character.isDigit(string.charAt(i))) i++;
		int j = i;
		while (j < string.length() && Character.isDigit(string.charAt(j))) j++;
		return Integer.parseInt(string.substring(i, j));

	}
	
//	public JSONObject getQuestion(int questionNumber) {
//		String[] fields = {"question_line_id"};
//		
//		String questionLine = null;
//		try {
//			questionLine = JDBC.read(fields, "test", "topic = " + "'" + topic + "' AND " + "difficulty = " + "'" + difficulty+"' AND " + "level = " + "'" + level+"';", "", "").toString();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		int questionLineId = firstInt(questionLine);
//		
//		try {
//			return JDBC.getQuestions(questionLineId).getJSONObject(questionNumber);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//		
//	}
	


}
