package action;

public class OptAction extends BaseAction {
	private String name;
	private String path;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String execute()throws Exception{
		System.out.println("执行业务处理..."+name);
		System.out.println(path);
		return SUCCESS;
	}
	
	public String add()throws Exception {
		System.out.println("执行添加处理...");
		return "add";
	}
	
	public String remove()throws Exception {
		System.out.println("执行删除处理...");
		return "remove";
	}
	public String modify()throws Exception {
		System.out.println("执行更新处理...");
		return "modify";
	}
	
	
	
	
	
	
}
