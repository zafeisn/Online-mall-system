package com.linjie.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户实体，以便获取用户信息
 * uid、username、password、phone
 * @author LinJie
 *
 */
@Setter@Getter
public class User {
	
	private String uid;
	private String username;
	private String password;
	private String phone;
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", phone=" + phone + "]";
	}
}
