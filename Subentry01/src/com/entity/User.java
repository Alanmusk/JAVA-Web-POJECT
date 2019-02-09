package com.entity;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 序列化类，保证数据的完整性和持久性。
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String userpwd;
	
	public User() {
		super();
	}
	
	public User(Integer id) {
		this.id = id;
	}
	public User(int id, String username, String userpwd) {
		super();
		this.id = id;
		this.username = username;
		this.userpwd = userpwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
}
