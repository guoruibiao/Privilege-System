package web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;
import domain.User;
import service.SecurityService;

/**
 * Servlet implementation class AddUserRoleUIServlet
 */
@WebServlet("/AddUserRoleUIServlet")
public class AddUserRoleUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserRoleUIServlet() {
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
			// 获知为哪一个用户授予角色
			String user_id = request.getParameter("user_id");
			SecurityService service = new SecurityService();
			User user = service.findUser(user_id);

			// 获取当前用户拥有哪些角色，系统中总共哪些角色
			List<Role> userroles = service.getUserRoles(user_id);
			List<Role> systemroles = service.getAllRole();

			// 将数据存到request域中，方便JSP页面获取
			request.setAttribute("user", user);
			request.setAttribute("userroles", userroles);
			request.setAttribute("systemroles", systemroles);

			// 派遣分发
			request.getRequestDispatcher("/jsp/adduserrole.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "为用户准备角色数据时失败！");
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
