package dao;

import static org.junit.Assert.fail;

import org.junit.Test;

import domain.Privilege;

public class PrivilegeDaoTest {

	public static PrivilegeDao dao = new PrivilegeDao();
	@Test
	public void testAdd() {
		Privilege p = new Privilege();
		p.setId("1");
		p.setName("");
		p.setDescription("第一个权限插入数据测试");
		dao.add(p);
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
