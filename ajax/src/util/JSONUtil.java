package util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {
	public static String toJson(Object object){
		//Object->JSONObject
		JSONObject jsonObject=JSONObject.fromObject(object);
		//JSONObject->String
		return jsonObject.toString();
	}
	
	public static Object toObject(String json,Class objClass){
		//String->JSONObject
		JSONObject jsonObject=JSONObject.fromObject(json);
		//JSONObject->Object
		return JSONObject.toBean(jsonObject, objClass);
	}
	
	public static String toJson(List list){
		JSONArray jsonArray=JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	public static List toList(String json,Class objClass){
		JSONArray jsonArray=JSONArray.fromObject(json);
		return JSONArray.toList(jsonArray, objClass);
	}
	
}
