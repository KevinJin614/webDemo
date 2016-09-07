package day01;

import java.util.HashMap;
import java.util.Map;

public class ActionConfig {
	private Map<String, ForwardConfig> forwards = new HashMap<String, ForwardConfig>();
	private String path;
	private String type;
	private String method;
	
	public void addForward(ForwardConfig forwardConfig){
		forwards.put(forwardConfig.getName(), forwardConfig);
	} 
	public ForwardConfig findForward(String name){
		return forwards.get(name);
	}
	
	
	public Map<String, ForwardConfig> getForwards() {
		return forwards;
	}
	public void setForwards(Map<String, ForwardConfig> forwards) {
		this.forwards = forwards;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
}
