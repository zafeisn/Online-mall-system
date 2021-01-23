package com.linjie.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统管理员实体类
 * @author LinJie
 *
 */
@Setter@Getter
public class Admin {

	private Integer id;
	private String username;
	private String password;
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
