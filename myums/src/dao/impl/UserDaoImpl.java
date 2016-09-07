package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCTemplate;
import dao.UserDao;
import entity.User;

public class UserDaoImpl extends JDBCTemplate<User> implements UserDao{
	
	private JDBCTemplate template;
	public UserDaoImpl(){
		if(template == null){
			template = new UserDaoImpl();
			return;
		}
	}

	@Override
	public void insert(User user) {
		String sql = new StringBuffer()
			.append(" insert into t_user ")
			.append("  		(username,password,name,phone,regist_date) ")
			.append(" values ")
			.append(" 		(?,?,?,?,?) ")
			.toString();
		template.update(sql, user.getUsername(),user.getPassword(),user.getName(),
							 user.getPhone(),user.getRegistDate());
	}

	@Override
	public User selectByUsername(String username) {
		String sql = new StringBuffer()
			.append(" select * from t_user ")
			.append(" where username = ? ")
			.toString();
		return (User) template.query(sql, username);
	}

	@Override
	public User getT(ResultSet rs) throws Exception {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setPhone(rs.getString("phone"));
		user.setRegistDate(rs.getDate("regist_date"));
		
		return user;
	}
	
}
