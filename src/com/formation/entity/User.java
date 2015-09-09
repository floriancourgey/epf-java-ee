package com.formation.entity;

public class User {
	private Long id;
	private String login;
	private String password;

	public User() {
	}

	public User(Long id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Builder builder(){
		return new Builder();
	}
	
	public static class Builder {

		private User user;

		private Builder() {
			user = new User();
		}

		public Builder setId(Long id) {
			user.id = id;
			return this;
		}

		public Builder setLogin(String login) {
			user.login = login;
			return this;
		}

		public Builder setPassword(String password) {
			user.password = password;
			return this;
		}

		public User build() {
			return user;
		}

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ "]";
	}
}
