package day10;

public class FormUtil {
	public static String getChecked(String value,String[] hobbies){
		if(hobbies!=null){
			for(String hobby:hobbies){
				if(value.equals(hobby)){
					return "checked";
				}
			}
		}
		return "";
	}
}
