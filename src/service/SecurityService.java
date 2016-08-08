package service;

import java.util.ArrayList;
import java.util.List;

import dao.PrivilegeDao;
import dao.RoleDao;
import dao.UserDao;
import domain.Privilege;
import domain.Role;
import domain.User;

/**
 * 对Web层提供全线相关的服务，其他的业务服务或者其他的服务有其他的service来实现
 * 
 * @author Administrator
 *
 */
public class SecurityService {

	private PrivilegeDao pdao = new PrivilegeDao();

	private RoleDao rdao = new RoleDao();

	private UserDao udao = new UserDao();

	/**
	 * 添加一个权限服务
	 * 
	 * @param p
	 */
	public void addPrivilege(Privilege p) {
		pdao.add(p);
	}

	/**
	 * 对Web层提供全线查找的服务
	 * 
	 * @param id
	 * @return
	 */
	public Privilege findPrivilege(String id) {
		return pdao.find(id);
	}

	/**
	 * 获取所有的权限服务
	 * 
	 * @return
	 */
	public List<Privilege> getPrivileges() {
		return pdao.getAll();
	}

	////////////////////////////////////////////// 角色服务相关
	/**
	 * 对web层提供添加角色的服务
	 * 
	 * @param role
	 */
	public void addRole(Role role) {
		rdao.add(role);
	}

	/**
	 * 得到一个角色
	 * 
	 * @param id
	 * @return
	 */
	public Role findRole(String id) {
		return rdao.find(id);
	}

	/**
	 * 得到角色所有的权限
	 * 
	 * @param role_id
	 * @return
	 */
	public List<Privilege> getRolePrivileges(String role_id) {
		return rdao.getRolePrivileges(role_id);
	}

	/**
	 * 得到所有的角色信息
	 * 
	 * @return
	 */
	public List<Role> getAllRole() {
		return rdao.getAll();
	}

	/**
	 * 为角色添加权限信息
	 * 
	 * @param role_id
	 * @param privilege_ids
	 */
	public void updateRolePrivilege(String role_id, String[] privilege_ids) {
		Role role = rdao.find(role_id);
		List<Privilege> privileges = new ArrayList<Privilege>();
		for (String pid : privilege_ids) {
			Privilege p = pdao.find(pid);
			privileges.add(p);
		}
		rdao.updatePrivilege(role, privileges);
	}

	////////////////////////////////// 对web层提供用户相关的服务
	public void addUser(User user) {
		udao.add(user);
	}

	public User findUser(String user_id) {
		return udao.find(user_id);
	}

	public List<User> getAllUser() {
		return udao.getAll();
	}

	/**
	 * 返回某一个用户拥有的角色
	 * 
	 * @param user_id
	 * @return
	 */
	public List<Role> getUserRoles(String user_id) {
		return udao.getUserRoles(user_id);
	}

	/**
	 * 更新某个用户的拥有的角色
	 * 
	 * @param user_id
	 * @param role_ids
	 */
	public void updateUserRoles(String user_id, String[] role_ids) {
		User user = udao.find(user_id);
		List<Role> roles = new ArrayList<Role>();
		for (String rid : role_ids) {
			Role role = rdao.find(rid);
			roles.add(role);
		}
		udao.updateUserRole(user, roles);
	}

}
