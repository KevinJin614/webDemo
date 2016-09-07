package config;

import java.util.HashMap;
import java.util.Map;

public class ModuleConfig {
	private Map<String,ActionConfig> actions=new HashMap<String, ActionConfig>();

	public void addActionConfig(ActionConfig action){
		actions.put(action.getPath(), action);
	}
	public ActionConfig findActionConfig(String path){
		return actions.get(path);
	}
	
	public Map<String, ActionConfig> getActions() {
		return actions;
	}

	public void setActions(Map<String, ActionConfig> actions) {
		this.actions = actions;
	}
	
	
}
