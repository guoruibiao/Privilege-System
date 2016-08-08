package domain;

import java.util.HashSet;
import java.util.Set;

public class Privilege {

	private String id;

	private String name;

	private String description;

	// 由于在页面显示层上没有必要获取权限对应了什么用户，所以这一个属性可以不写，这体现了Bean设计的灵活性
	private Set roles = new HashSet();

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

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
}
