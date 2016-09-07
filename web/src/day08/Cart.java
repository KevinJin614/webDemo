package day08;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class Cart implements Serializable {
	private List<Item> items=new ArrayList<Item>();
	private Double price=0.0;
	
	public void add(Integer productId){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql=new StringBuffer()
				.append("select * ")
				.append("from t_product ")
				.append("where id=? ")
				.toString();
			ps=con.prepareStatement(sql);
			ps.setInt(1, productId);
			
			rs=ps.executeQuery();
			Product product=new Product();
			if(rs.next()){
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
			}
			
			
			price+=product.getPrice();
			
			for (Item item: items) {
				if(item.getProduct().getId().equals(productId)){
					//存在
					item.setNum(item.getNum()+1);
					item.setPrice(item.getPrice()+product.getPrice());
					
					con.commit();
					return;
				}
			}
			Item item=new Item();
			item.setPrice(product.getPrice());
			item.setProduct(product);
			item.setNum(1);
			items.add(item);
			
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
		
	}
	
	public void removeById(Integer productId){
		for(int i=0;i<items.size();i++){
			Item item=items.get(i);
			if(item.getProduct().getId().equals(productId)){
				price-=item.getPrice();
				items.remove(item);
			}
		}
	}
	
	public void removeByIds(List<Integer> productIds){
		for (Integer productId : productIds) {
			removeById(productId);
		}
	}
	
	public void clear(){
		items=new ArrayList<Item>();
		price=0.0;
	}
	
	public List<Item> findAll(){
		return items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
