package config;

import java.util.HashMap;
import java.util.Map;

public class ActionConfig {
	private String path;
	private String type;
	private String method;
	private Map<String,ForwardConfig> forwards=new HashMap<String, ForwardConfig>();
	
	public void addForwardConfig(ForwardConfig forward){
		forwards.put(forward.getName(), forward);
	}
	
	public ForwardConfig findForwardConfig(String name){
		return forwards.get(name);
	}
	
	public Map<String, ForwardConfig> getForwards() {
		return forwards;
	}
	public void setForwards(Map<String, ForwardConfig> forwards) {
		this.forwards = forwards;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
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
}
