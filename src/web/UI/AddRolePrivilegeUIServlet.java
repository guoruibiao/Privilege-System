package web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Privilege;
import domain.Role;
import service.SecurityService;

/**
 * 添加用户角色的数据准备，将要跳转到一个给予用户显示的jsp页面 Servlet implementation class
 * AddRolePrivilegeUIServlet
 */
@WebServlet("/AddRolePrivilegeUIServlet")
public class AddRolePrivilegeUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRolePrivilegeUIServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SecurityService service = new SecurityService();
			// 得到角色信息
			String role_id = request.getParameter("role_id");
			Role role = service.findRole(role_id);
			// 得到角色当前拥有的权限
			List<Privilege> rolePrivileges = service.getRolePrivileges(role_id);
			// 得到系统的所有的权限
			List<Privilege> systemPrivileges = service.getPrivileges();

			// 数据准备完毕，交给jsp页面显示即可
			request.setAttribute("role", role);
			request.setAttribute("rolePrivileges", rolePrivileges);
			request.setAttribute("systemPrivileges", systemPrivileges);
			
			request.getRequestDispatcher("/jsp/addroleprivilege.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "添加用户权限数据的准备过程失败!\n" + e);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
