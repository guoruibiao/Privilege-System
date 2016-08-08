package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Privilege;
import utils.JDBCUtils;

public class PrivilegeDao {

	public void add(Privilege p) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into privilege(id,name,description) values(?,?,?)";
			Object[] params = { p.getId(), p.getName(), p.getDescription() };
			runner.update(conn, sql, params);
			JDBCUtils.release(conn);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Privilege find(String id) {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from privilege where id = ?";
			Privilege p = runner.query(conn, sql, id, new BeanHandler<>(Privilege.class));
			JDBCUtils.release(conn);
			return p != null ? p : null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Privilege> getAll() {
		try {
			Connection conn = JDBCUtils.getConn();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from privilege";
			List<Privilege> privileges = runner.query(conn, sql, new BeanListHandler<>(Privilege.class));
			JDBCUtils.release(conn);
			return privileges != null ? privileges : null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
