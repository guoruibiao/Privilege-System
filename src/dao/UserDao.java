package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Role;
import domain.User;
import utils.JDBCUtils;

public class UserDao {

	public void add(User user) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into user(id,username,password) values(?,?,?)";
			Object[] params = { user.getId(), user.getUsername(), user.getPassword() };
			runner.update(conn, sql, params);
			JDBCUtils.release(conn);
		} catch (

		Exception e) {
			throw new RuntimeException(e);
		}

	}

	public User find(String id) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from user where id =?";
			User user = runner.query(conn, sql, id, new BeanHandler<User>(User.class));
			JDBCUtils.release(conn);
			return user != null ? user : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public User find(String username, String password) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from user where username=? and password=?";
			Object[] params = { username, password };
			User user = runner.query(conn, sql, params, new BeanHandler<User>(User.class));
			JDBCUtils.release(conn);
			return user != null ? user : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> getAll() {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from user";
			List<User> users = runner.query(conn, sql, new BeanListHandler<User>(User.class));
			JDBCUtils.release(conn);
			return users != null ? users : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Role> getUserRoles(String id) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "select r.* from user_role ur,role r where ur.user_id=? and ur.role_id=r.id";
			List<Role> roles = runner.query(conn, sql, id, new BeanListHandler<Role>(Role.class));
			JDBCUtils.release(conn);
			return roles != null ? roles : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void updateUserRole(User user, List<Role> roles) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			// 为防止用户角色重复授予先删除用户拥有的所有的角色
			String sql = "delete from user_role where user_id =?";
			runner.update(conn, sql, user.getId());
			// 在给用户赋予新的角色
			for (int i = 0; i < roles.size(); i++) {
				Role role = roles.get(i);
				sql = "insert into user_role(user_id,role_id) values(?,?)";
				Object[] params = { user.getId(), role.getId() };
				runner.update(conn, sql, params);
			}
			JDBCUtils.release(conn);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
