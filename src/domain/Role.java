package domain;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private String id;
	private String name;
	private String description;
	
	// 记录当前角色拥有什么权限
	private Set<Privilege> privileges = new HashSet<Privilege>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", privileges=" + privileges
				+ "]";
	}
	
}
