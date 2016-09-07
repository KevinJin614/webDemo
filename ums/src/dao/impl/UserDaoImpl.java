package dao.impl;

import java.util.List;

import rowmapper.UserRowMapper;
import util.JDBCTemplate;
import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {
	
	private JDBCTemplate template;
	
	public UserDaoImpl() {
		template=new JDBCTemplate();
	}
	
	public void insert(User user) {
		String sql=new StringBuffer()
			.append("insert into t_user ")
			.append("    (username,password,name,phone,regist_date) ")
			.append("values ")
			.append("    (?,?,?,?,?) ")
			.toString();
		template.update(sql, user.getUsername(),user.getPassword(),user.getName(),user.getPhone(),user.getRegistDate());
	}

	public User selectByUsername(String username) {
		String sql=new StringBuffer()
			.append("select * ")
			.append("from t_user ")
			.append("where username=? ")
			.toString();
		List<User> users=template.query(sql, new UserRowMapper(), username);
		return users.size()==0?null:users.get(0);
	}

	public User selectByUsernameAndPassword(String username, String password) {
		String sql=new StringBuffer()
			.append("select * ")
			.append("from t_user ")
			.append("where username=? ")
			.append("and password=? ")
			.toString();
		List<User> users=template.query(sql, new UserRowMapper(), username, password);
		return users.size()==0?null:users.get(0);
	}

	public void deleteById(Integer id) {
		String sql = new StringBuffer()
			.append("delete ")
			.append("from t_user ")
			.append("where id=? ")
			.toString();
		template.update(sql, id);
	}

	public List<User> selectAll() {
		String sql = new StringBuffer()
			.append("select * ")
			.append("from t_user ")
			.toString();
		List<User> users = template.query(sql, new UserRowMapper());
		System.out.println(users.size());
		return users;
	}

	public User selectById(Integer id) {
		String sql = new StringBuffer()
			.append("select * ")
			.append("from t_user ")
			.append("where id=? ")
			.toString();
		List<User> users = template.query(sql, new UserRowMapper(), id);
		return users.size()==0?null:users.get(0);
	}

	public void update(User user) {
		String sql = new StringBuffer()
			.append("update ")
			.append("t_user ")
			.append("set name=? ")
			.append(",phone=? ")
			.append("where id=? ")
			.toString();
		template.update(sql, user.getName(),user.getPhone(),user.getId());
	}
	
	
	
	
	

}
