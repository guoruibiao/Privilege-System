package web.controller;

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
 * Servlet implementation class AddUserRoleServlet
 */
@WebServlet("/AddUserRoleServlet")
public class AddUserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SecurityService service = new SecurityService();
			
			String user_id = request.getParameter("user_id");
			
			String[] role_ids = request.getParameterValues("role_id");
			service.updateUserRoles(user_id, role_ids);
			
			request.setAttribute("message", "为用户授予角色时成功！！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "为用户授予角色时失败！"+e);
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
