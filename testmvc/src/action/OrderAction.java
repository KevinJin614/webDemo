package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;

import util.JDBCUtil;


public class OrderAction {
	
	public String create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Cart cart=(Cart) session.getAttribute("cart");
		String no = (String) session.getAttribute("no");
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
				.append("insert into t_order ")
				.append("    (user_id,no,price) ")
				.append("values ")
				.append("    (?,?,?) ")
				.toString();
			
			ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, user.getId());
			ps.setString(2,no);
			ps.setDouble(3, cart.getPrice());
			
			ps.executeUpdate();
			
			rs=ps.getGeneratedKeys();
			Integer orderId=null;
			if(rs.next()){
				orderId=rs.getInt(1);
			}
			
			sql=new StringBuffer()
				.append("insert into t_item ")
				.append("    (product_id,num,price,order_id) ")
				.append("values ")
				.append("    (?,?,?,?) ")
				.toString();
			
			ps=con.prepareStatement(sql);
			
			List<Item> items=cart.getItems(); 
			for (Item item : items) {
				ps.setInt(1, item.getProduct().getId());
				ps.setInt(2, item.getNum());
				ps.setDouble(3, item.getPrice());
				ps.setInt(4, orderId);
				ps.executeUpdate();
			}
			
			con.commit();
			
			request.getSession().setAttribute("orderNo", no);
			
//			response.sendRedirect(request.getContextPath()+"/shop/success.jsp?orderNo="+no);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return "success";
	}
	
	private synchronized String getNo(){
		Date date=new Date();
		return new SimpleDateFormat("yyyyMMddHHmmssSS").format(date);
	}

	
	public String findByUserId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Order> orders=new ArrayList<Order>();
		try {
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
			String sql=new StringBuffer()
				.append("select id,no ")
				.append("from t_order ")
				.append("where user_id=? ")
				.toString();
			ps=con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				Order order=new Order();
				order.setId(rs.getInt("id"));
				order.setNo(rs.getString("no"));
				orders.add(order);
			}
			
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		request.setAttribute("orders", orders);
		return "success";
//		request.getRequestDispatcher("/shop/orderList.jsp").forward(request, response);
		
	}
	
	public String findByOrderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId=request.getParameter("orderId");
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Order order=null;
		try {
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
				.append("select u.username, ")
				.append("       o.no, ")
				.append("       p.name, ")
				.append("       i.num, ")
				.append("       i.price, ")
				.append("       o.price, ")
				.append("       (select count(1) ")
				.append("        from t_item item ")
				.append("	     where item.order_id=o.id) count ")
				.append("from t_order o ")
				.append("left join t_user u ")
				.append("	on o.user_id=u.id ")
				.append("left join t_item i ")
				.append("	on o.id=i.order_id ")
				.append("left join t_product p ")
				.append("	on i.product_id=p.id ")
				.append("where o.id=? ")
				.toString();
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(orderId));
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				if(order==null){
					order=new Order();
					User user=new User();
					user.setUsername(rs.getString("u.username"));
					order.setUser(user);
					order.setNo(rs.getString("o.no"));
					order.setPrice(rs.getDouble("o.price"));
					order.setCount(rs.getInt("count"));
				}
				Item item=new Item();
				Product product=new Product();
				product.setName(rs.getString("p.name"));
				item.setProduct(product);
				item.setNum(rs.getInt("i.num"));
				item.setPrice(rs.getDouble("i.price"));
				order.addItem(item);
			}
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		request.setAttribute("order", order);
		return "success";
//		request.getRequestDispatcher("/shop/myOrder.jsp").forward(request, response);
	}
}
