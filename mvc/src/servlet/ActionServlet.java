package servlet;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;

import config.ActionConfig;
import config.ForwardConfig;
import config.ModuleConfig;

public class ActionServlet extends HttpServlet {
	private ModuleConfig moduleConfig;
	private Map<String,Object> actions;
	@Override
	public void init() throws ServletException {
		actions=new HashMap<String, Object>();
//		解析xml代码
		Digester digester=DigesterLoader.createDigester(ActionServlet.class
																	 .getClassLoader()
																	 .getResource("config/rule.xml"));
		moduleConfig=new ModuleConfig();
		digester.push(moduleConfig);
		try {
			digester.parse(ActionServlet.class
										.getClassLoader()
										.getResourceAsStream("action.xml"));
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		} 
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//获得请求路径并做处理
			String path=request.getServletPath();
	//		System.out.println(path);
			path=path.substring(0, path.lastIndexOf(".do"));
			
			System.out.println(path);
			
			//根据请求路径查找对应的action的配置
			ActionConfig actionConfig=moduleConfig.findActionConfig(path);
			
			//根据配置的type和method调用对应的方法
			Class actionClass = Class.forName(actionConfig.getType());
			//创建action对象，对象是单例的
			Object action=actions.get(actionConfig.getType());
			if(action==null){
				action=actionClass.newInstance();
				actions.put(actionConfig.getType(), action);
			}
			
			
			Method method=actionClass.getMethod(actionConfig.getMethod(),HttpServletRequest.class,HttpServletResponse.class);
			
			String result=(String) method.invoke(action, request,response);
			
			//根据返回的结果和配置，生成对应的响应
			ForwardConfig forwardConfig=actionConfig.findForwardConfig(result);
			if(forwardConfig.isRedirect()==true){
				response.sendRedirect(request.getContextPath()+forwardConfig.getPath());
			}else{
				request.getRequestDispatcher(forwardConfig.getPath()).forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}
