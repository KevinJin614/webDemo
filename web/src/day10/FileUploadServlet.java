package day10;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name=request.getParameter("name");
//		String file=request.getParameter("file");
//		
//		System.out.println(name);
//		System.out.println(file);
		
		
//		InputStream in=request.getInputStream();
		
		//提供解析文件时的一些参数
		DiskFileItemFactory factory=new DiskFileItemFactory();
		
		//解析请求数据的工具
		ServletFileUpload fileUpload=new ServletFileUpload(factory);
		
		try {
			//解析请求
			List<FileItem> items=fileUpload.parseRequest(request);
			
			Map<String,FileItem> map=new HashMap<String, FileItem>();
			
			for (FileItem item : items) {
//				System.out.println(item.getFieldName());
				map.put(item.getFieldName(), item);
			}
			
			
			String name=map.get("name").getString();
			System.out.println("name="+name);
			
			
			FileItem file=map.get("file");
			
			System.out.println(file.getFieldName());
			System.out.println(file.getName());
			System.out.println(file.getContentType());
			System.out.println(file.getSize());
			
			if(file.getName().endsWith(".jsp")){
				request.setAttribute("message", "不能上传.jsp文件");
				request.getRequestDispatcher("/upload.jsp").forward(request, response);
				return;
			}
			
			
			file.write(new File(getServletContext().getRealPath("/upload"),file.getName()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
