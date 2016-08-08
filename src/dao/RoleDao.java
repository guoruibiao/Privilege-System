package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Privilege;
import domain.Role;
import utils.JDBCUtils;

public class RoleDao {

	public void add(Role role) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into role(id,name,description) values(?,?,?)";
			Object[] params = { role.getId(), role.getName(), role.getDescription() };
			runner.update(conn, sql, params);
			JDBCUtils.release(conn);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Role find(String id) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from role where id =?";
			Role role = runner.query(conn, sql, id, new BeanHandler<Role>(Role.class));
			JDBCUtils.release(conn);
			return role != null ? role : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Role> getAll() {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from role";
			List<Role> roles = runner.query(conn, sql, new BeanListHandler<Role>(Role.class));
			JDBCUtils.release(conn);
			return roles != null ? roles : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取当前角色已经拥有了什么权限
	 * 
	 * @param roleid
	 * @return
	 */
	public List<Privilege> getRolePrivileges(String role_id) {

		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "select p.* from role_privilege rp,privilege p where role_id=? and rp.privilege_id=p.id";
			List<Privilege> privileges = runner.query(conn, sql, role_id,
					new BeanListHandler<Privilege>(Privilege.class));
			return privileges != null ? privileges : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 为某个角色授权<br>
	 * 即更新中间表之间的关系信息
	 * 
	 * @param role
	 * @param privileges
	 */
	public void updatePrivilege(Role role, List<Privilege> privileges) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();

			// 为了防止重复的角色授权，在每次授权之前删除该角色的所有的权限，在进行添加即可
			String sql = "delete from role_privilege where role_id=?";
			runner.update(conn, sql, role.getId());

			// 重新添加权限
			for (Privilege p : privileges) {
				sql = "insert into role_privilege(role_id,privilege_id) values(?,?)";
				Object[] params = { role.getId(), p.getId() };
				runner.update(conn, sql, params);
			}
			JDBCUtils.release(conn);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
