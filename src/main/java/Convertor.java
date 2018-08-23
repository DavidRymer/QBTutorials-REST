import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


/**
 * Utility for converting ResultSets into some Output formats
 */
public class Convertor {


    public static JSONArray convertResultSetIntoJSON(ResultSet rs) throws Exception {
    	JSONArray json = new JSONArray();
    	ResultSetMetaData rsmd = rs.getMetaData();
    	while(rs.next()) {
    	  int numColumns = rsmd.getColumnCount();
    	  JSONObject obj = new JSONObject();
    	  for (int i=1; i<=numColumns; i++) {
    	    String column_name = rsmd.getColumnName(i);
    	    obj.put(column_name, rs.getObject(column_name));
    	  }
    	  json.put(obj);
    	}
    	return json;
    }



}