
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//控制器
		String path=request.getServletPath();
		if("/login.user".equals(path)){
			String result=login(request, response);
			if("success".equals(result)){
				
			}
			if("fail".equals(result)){
				
			}
		}
		if("/regist.user".equals(path)){
			regist(request, response);
		}
		if("/findAll.user".equals(path)){
			String result=findAll(request, response);
			if("success".equals(result)){
				request.getRequestDispatcher("/findAll.jsp").forward(request, response);
			}
		}
		if("/find.user".equals(path)){
			String result=findAll(request, response);
			if("success".equals(result)){
				//生成excel表格
			}
		}
	}
	
	//模型
	public String regist(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("用户注册...");
		String username=request.getParameter("username");
		if("abc".equals(username)){
			return "success";
		}
		request.setAttribute("message", "用户名已存在");
		return "fail";
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("用户登陆...");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if("abc".equals(username)&&"123".equals(password)){
			return "success";
		}
		request.setAttribute("message", "用户名或密码错误");
		return "fail";
	}
	
	public String findAll(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		return null;
	}
}
