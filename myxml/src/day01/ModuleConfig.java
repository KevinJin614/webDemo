package day01;

import java.util.HashMap;
import java.util.Map;

public class ModuleConfig {
	private Map<String, ActionConfig> actions = new HashMap<String, ActionConfig>();
	
	public void addAction(ActionConfig actionConfig){
		actions.put(actionConfig.getPath(), actionConfig);
	}
	public ActionConfig findAction(String path){
		return actions.get(path);
	}

	public Map<String, ActionConfig> getActions() {
		return actions;
	}

	public void setActions(Map<String, ActionConfig> actions) {
		this.actions = actions;
	}
	
	
}
