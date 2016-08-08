package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Privilege;
import service.SecurityService;
import utils.WebUtils;

/**
 * Servlet implementation class AddPrivilegeServlet
 */
@WebServlet("/AddPrivilegeServlet")
public class AddPrivilegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPrivilegeServlet() {
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
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Privilege p = new Privilege();
			p.setId(WebUtils.makeUUID());
			p.setName(name);
			p.setDescription(description);
			SecurityService service = new SecurityService();
			service.addPrivilege(p);

			request.setAttribute("message", "权限添加成功！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "权限添加失败！"+e);
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
