package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;
import service.SecurityService;
import utils.WebUtils;

/**
 * 增加角色的权限<br>
 * Servlet implementation class AddRolePrivilegeServlet
 */
@WebServlet("/AddRolePrivilegeServlet")
public class AddRolePrivilegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRolePrivilegeServlet() {
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
			String role_id = request.getParameter("role_id");
			String[] privilege_ids = request.getParameterValues("privilege_id");
			SecurityService service = new SecurityService();
			service.updateRolePrivilege(role_id, privilege_ids);
			request.setAttribute("message", "角色授权添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "角色授权添加失败！" + e);
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
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
