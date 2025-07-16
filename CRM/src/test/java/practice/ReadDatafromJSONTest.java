package practice;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadDatafromJSONTest {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		
		//Step 1 : parse json physical file in to java object using jsonparse class
		JSONParser parser = new JSONParser();
		Object obj=parser.parse(new FileReader("./src/test/resources/AppData.json"));
		
		//2nd method
		//Object obj=parser.parse(new FileReader("C:\\Users\\SRIKANTH\\OneDrive\\Documents\\AppData.json"));
		
		//step 2 : convert java object in to jsonobject using down casting
		JSONObject map = (JSONObject)obj;
		
		//step 3 : get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
	}
}
