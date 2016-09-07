package factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
	
	private static Map<String,Object> objects = new HashMap<String, Object>();
	static{
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							ObjectFactory.class
										 .getClassLoader()
										 .getResourceAsStream("object.txt")));
			String s = null;
			while((s = br.readLine()) != null){
				String[] st = s.split("=");
				objects.put(st[0], Class.forName(st[1]).newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("object文件异常:"+e.getMessage());
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	
	
	public static Object getObject(String key){
		return objects.get(key);
	}
}
