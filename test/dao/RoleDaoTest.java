package dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import domain.Privilege;
import domain.Role;

public class RoleDaoTest {

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRolePrivileges() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePrivilege() {
		Role role = new Role();
		role.setId("0324b8a8-ef2d-4f8d-96a9-e83b77db95b4");
		List<Privilege> privileges = new ArrayList<Privilege>();
		PrivilegeDao dao = new PrivilegeDao();
		privileges = dao.getAll();
		
		RoleDao rdao = new RoleDao();
		rdao.updatePrivilege(role, privileges);
	}

}
