package day07;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CodeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		System.out.println(path);
		if("/show.code".equals(path)){
			show(request, response);
		}
		if("/submit.code".equals(path)){
			submit(request, response);
		}
		if("/validate.code".equals(path)){
			validate(request, response);
		}
	}
	
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random random=new Random();
		//在内存中创建画图板
		BufferedImage image=new BufferedImage(70,35,BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics graphics=image.getGraphics();
		
		//设置画笔颜色
//		graphics.setColor(Color.RED);
		graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
		
		//画一个带填充色的矩形
		graphics.fillRect(0, 0, 70, 35);
		
		//设置画笔颜色
		graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
		
		//设置字体
		graphics.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,18));
		
		//生成5位随机字符串，字符串包括a-z和0-9
		String s="abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer buffer=new StringBuffer();
	
		for (int i = 0; i < 5; i++) {
			int index=random.nextInt(s.length());
			buffer.append(s.charAt(index));
		}
		//往图片上写文字
		graphics.drawString(buffer.toString(), 10, 30);
		
		request.getSession().setAttribute("code", buffer.toString());
		
		response.setContentType("image/jpeg");
		
		OutputStream out=response.getOutputStream();
		
		//压缩成JPEG格式的图片
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image);
		
	}
	
	private void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		String code = (String) request.getSession().getAttribute("code");
		String validateCode = request.getParameter("code");
		if(code.equals(validateCode)){
			out.print("验证码正确");
			return;
		}
		out.print("验证码错误");
		
	}
	
		
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String code=request.getParameter("code");
		
		if(!code.equals(request.getSession().getAttribute("code"))){
			request.setAttribute("message", "验证码错误");
			request.getRequestDispatcher("/code.jsp").forward(request, response);
			return;
		}
		
		
		System.out.println("name="+name);
		
		request.getSession().removeAttribute("code");
		response.sendRedirect(request.getContextPath()+"/success.jsp");
	}

	
	
	
	
	
	
	
}
