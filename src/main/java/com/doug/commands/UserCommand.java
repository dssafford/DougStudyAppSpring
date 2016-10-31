package com.doug.commands;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Doug on 10/30/16.
 */
public class UserCommand {

	@NotEmpty
	@Size(min = 2, max = 50)
	private String username;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String password;

	private boolean enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}

