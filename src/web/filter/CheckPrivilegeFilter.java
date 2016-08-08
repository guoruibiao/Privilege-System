package web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Privilege;
import domain.User;
import service.SecurityService;

/**
 * 用于检测当前用户，拥有哪些权限，这是此项目的核心
 * 
 * @author Administrator
 *
 */
public class CheckPrivilegeFilter implements Filter {

	/**
	 * 模拟数据库中存储的访问资源所对应的权限
	 * 
	 * <br>
	 * 思路就是使用过滤器方式对要访问的资源进行过滤。拥有相关的权限的才可以正常的访问。
	 */
	public static Map<String, Privilege> map = new HashMap<String, Privilege>();
	static {
		Privilege add_p = new Privilege();
		add_p.setName("add");
		Privilege delete_p = new Privilege();
		delete_p.setName("delete");
		Privilege find_p = new Privilege();
		find_p.setName("find");
		map.put("URI_add", add_p);
		map.put("URI_delete", delete_p);
		map.put("URI_find", find_p);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 得到用户请求的URI资源定位
		String uri = req.getRequestURI();

		// 得到用户带有的自身的权限
		Privilege p = map.get(uri);

		// 处理权限问题。如果访问资源需要的权限为空，则放行，否则只有拥有相关权限的用户才能正常的访问该资源
		if (p == null) {
			chain.doFilter(request, response);
			return;
		}
		// 需要权限的话，则检查用户是否登陆，未登录则提示用户先登录
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("message", "请先登录！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}

		// 若用户已登录，则获取该用户拥有的所有的权限，然后
		SecurityService service = new SecurityService();
		List<Privilege> userPrivileges = service.getUserAllPrivilege(user.getId());
		// 判断用户拥有的权限中是否包含资源访问需要的权限
		if (!userPrivileges.contains(p)) {
			request.setAttribute("message", "对不起，你的权限无法访问当前资源！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		// 拥有全部权限，正常的访问资源
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
