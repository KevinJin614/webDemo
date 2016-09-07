package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cart;


public class CartAction {
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId=request.getParameter("productId");
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		cart.add(Integer.parseInt(productId));
		return "success";
	}

	public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		cart.clear();
		return "success";
	}

	public String removeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId=request.getParameter("productId");
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		cart.removeById(Integer.parseInt(productId));
//		response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");
		return "success";
	}
	public String removeByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] productIds=request.getParameterValues("c");
		List<Integer> ids=new ArrayList<Integer>();
		for (String productId : productIds) {
			ids.add(Integer.parseInt(productId));
		}
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		cart.removeByIds(ids);
//		response.sendRedirect(request.getContextPath()+"/shop/cart.jsp");
		return "success";
	}
}
