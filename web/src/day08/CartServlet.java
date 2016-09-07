package day08;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if("/add.cart".equals(path)){
			add(request, response);
		}
		if("/clear.cart".equals(path)){
			clear(request, response);
		}
		if("/removeById.cart".equals(path)){
			removeById(request, response);
		}
		if("/removeByIds.cart".equals(path)){
			removeByIds(request, response);
		}
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId=request.getParameter("productId");
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		cart.add(Integer.parseInt(productId));
		response.sendRedirect(request.getContextPath()+"/findAll.product");
	}

	private void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		cart.clear();
//		request.getSession().setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");
	}

	private void removeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId=request.getParameter("productId");
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		cart.removeById(Integer.parseInt(productId));
		response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");
	}
	private void removeByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] productIds=request.getParameterValues("c");
		List<Integer> ids=new ArrayList<Integer>();
		for (String productId : productIds) {
			ids.add(Integer.parseInt(productId));
		}
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		cart.removeByIds(ids);
		response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");
	}
	
	
	
	
	
	
	
	
	
}
